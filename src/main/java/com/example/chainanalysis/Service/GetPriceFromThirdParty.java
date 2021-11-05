package com.example.chainanalysis.Service;

import com.example.chainanalysis.Model.BittrexPrice;
import com.example.chainanalysis.Model.Exchange;
import com.example.chainanalysis.Model.BinancePrice;
import com.example.chainanalysis.Repository.BittrexPriceRepository;
import com.example.chainanalysis.Repository.ExchangeRepository;
import com.example.chainanalysis.Repository.BinancePriceRepository;
import com.example.chainanalysis.Service.RestObjects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class GetAndStoreDaemon implements Runnable {

    private final Map<String, List<String>> urls; // Exchange name, Crypto name
    private final ExchangeRepository exchangeRepository;
    private final BinancePriceRepository binancePriceRepository;
    private final BittrexPriceRepository bittrexPriceRepository;
    private final Long interval;

    GetAndStoreDaemon(Long interval, ExchangeRepository exchangeRepository, BinancePriceRepository binancePriceRepository, BittrexPriceRepository bittrexPriceRepository) {
        this.urls = new HashMap<>();
        this.interval = interval;
        this.exchangeRepository = exchangeRepository;
        this.binancePriceRepository = binancePriceRepository;
        this.bittrexPriceRepository = bittrexPriceRepository;
    }

    @Override
    public void run() {
        try {
            // Wait for exchange table initialization
            Thread.sleep(5000);

            // Initialize all target urls
            List<Exchange> exchanges = this.exchangeRepository.findAll();
            for(Exchange exc:exchanges) {
                this.urls.put(exc.getName(), new ArrayList<>());
                // substitute {} with the crypto name
                String[] allCryptosInThisExchange = exc.getCryptoNames().split(",");
                for(String cryptoName:allCryptosInThisExchange) {
                    this.urls.get(exc.getName()).add(exc.getApiURL().replace("{}", cryptoName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            while(true) {
                ExecutorService threadPool = Executors.newSingleThreadExecutor();
                // System.out.println(this.urls.get("Binance"));
                // List of single crypto price pairs in an exchange
                // We assume that the table of one exchange
                Future<List<DataObj>> binance = threadPool.submit(new BinanceCallableObj(this.urls.get("Binance")));
                Future<List<DataObj>> bittrex = threadPool.submit(new BittrexCallableObj(this.urls.get("Bittrex")));

                BinancePrice binancePrice = new BinancePrice();
                binancePrice.setTime(Time.valueOf(LocalTime.now()));
                // Loop over the crypto in the exchange
                for(DataObj crypto: binance.get()) {
                    if(crypto.getSymbol().equals("BTCUSDT")) {
                        binancePrice.setBTCBuyPrice(crypto.getBuyPrice());
                        binancePrice.setBTCSellPrice(crypto.getSellPrice());
                    } else if(crypto.getSymbol().equals("ETHUSDT")) {
                        binancePrice.setETHBuyPrice(crypto.getBuyPrice());
                        binancePrice.setETHSellPrice(crypto.getSellPrice());
                    }
                }
                this.binancePriceRepository.save(binancePrice);

                BittrexPrice bittrexPrice = new BittrexPrice();
                bittrexPrice.setTime(Time.valueOf(LocalTime.now()));
                for(DataObj crypto: bittrex.get()) {
                    if(crypto.getSymbol().equals("BTC-USDT")) {
                        bittrexPrice.setBTCBuyPrice(crypto.getBuyPrice());
                        bittrexPrice.setBTCSellPrice(crypto.getSellPrice());
                    } else {
                        bittrexPrice.setETHBuyPrice(crypto.getBuyPrice());
                        bittrexPrice.setETHSellPrice(crypto.getSellPrice());
                    }
                }
                this.bittrexPriceRepository.save(bittrexPrice);


                Thread.sleep(this.interval);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


@Service
@DependsOn({"ExchangeRepository", "BinancePriceRepository", "BittrexPriceRepository"})
public class GetPriceFromThirdParty {
    private final ExchangeRepository exchangeRepository;
    private final BinancePriceRepository binancePriceRepository;
    private final BittrexPriceRepository bittrexPriceRepository;

    @Autowired
    public GetPriceFromThirdParty(ExchangeRepository exchangeRepository, BinancePriceRepository binancePriceRepository, BittrexPriceRepository bittrexPriceRepository) {
        this.exchangeRepository = exchangeRepository;
        this.binancePriceRepository = binancePriceRepository;
        this.bittrexPriceRepository = bittrexPriceRepository;

        // Spawn a daemon thread to collect data
        GetAndStoreDaemon getAndStoreDaemon = new GetAndStoreDaemon(2000L, this.exchangeRepository, this.binancePriceRepository, this.bittrexPriceRepository);
        Thread t = new Thread(getAndStoreDaemon);
        t.setDaemon(true);
        t.start();
    }
}

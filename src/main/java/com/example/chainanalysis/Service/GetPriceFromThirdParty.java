package com.example.chainanalysis.Service;

import com.example.chainanalysis.Model.Exchange;
import com.example.chainanalysis.Model.Price;
import com.example.chainanalysis.Repository.ExchangeRepository;
import com.example.chainanalysis.Repository.PriceRepository;
import com.example.chainanalysis.Service.BinanceCallable;
import com.example.chainanalysis.Service.BinanceDataObj;
import com.example.chainanalysis.Service.BittrexCallable;
import com.example.chainanalysis.Service.BittrexDataObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class GetAndStoreDaemon implements Runnable {

    private final Map<String, String> urls;
    private final PriceRepository priceRepository;
    private final ExchangeRepository exchangeRepository;
    private final Long interval;

    GetAndStoreDaemon(Long interval, PriceRepository priceRepository, ExchangeRepository exchangeRepository) {
        this.urls = new HashMap<>();
        this.interval = interval;
        this.priceRepository = priceRepository;
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);

            // Fetch data in a fixed interval and store them in repository
            // Initialize all target urls
            List<Exchange> exchanges = this.exchangeRepository.findAll();
            System.out.println("#################");
            System.out.println(exchanges.size());
            for(Exchange exc:exchanges) {
                this.urls.put(exc.getName(), exc.getApiURL());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            while(true) {
                ExecutorService threadPool = Executors.newSingleThreadExecutor();
                System.out.println(this.urls.get("Binance"));
                Future<BinanceDataObj> binance = threadPool.submit(new BinanceCallable(this.urls.get("Binance")));
                Future<BittrexDataObj> bittrex = threadPool.submit(new BittrexCallable(this.urls.get("Bittrex")));

                Price price = new Price();
                price.setBinanceBTCBuyPrice(binance.get().getAskPrice());
                price.setBinanceBTCSellPrice(binance.get().getBidPrice());
                price.setBinanceETHBuyPrice(binance.get().getAskPrice());
                price.setBinanceETHSellPrice(binance.get().getBidPrice());

                price.setBittrexBTCBuyPrice(bittrex.get().getAskRate());
                price.setBittrexBTCSellPrice(bittrex.get().getBidRate());
                price.setBittrexETHBuyPrice(bittrex.get().getAskRate());
                price.setBittrexETHSellPrice(bittrex.get().getBidRate());

                price.setTime(Time.valueOf(LocalTime.now()));

                this.priceRepository.save(price);

                Thread.sleep(this.interval);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


@Service
@DependsOn({"ExchangeRepository", "PriceRepository"})
public class GetPriceFromThirdParty {
    private final ExchangeRepository exchangeRepository;
    private final PriceRepository priceRepository;

    @Autowired
    public GetPriceFromThirdParty(ExchangeRepository exchangeRepository, PriceRepository priceRepository) {
        this.exchangeRepository = exchangeRepository;
        this.priceRepository = priceRepository;

        // Spawn a daemon thread to collect data
        GetAndStoreDaemon getAndStoreDaemon = new GetAndStoreDaemon(2000L, this.priceRepository, this.exchangeRepository);
        Thread t = new Thread(getAndStoreDaemon);
        t.setDaemon(true);
        t.start();
    }
}

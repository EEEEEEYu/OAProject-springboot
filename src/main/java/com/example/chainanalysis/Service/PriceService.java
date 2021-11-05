package com.example.chainanalysis.Service;

import com.example.chainanalysis.Model.BinancePrice;
import com.example.chainanalysis.Model.BittrexPrice;
import com.example.chainanalysis.Repository.BinancePriceRepository;
import com.example.chainanalysis.Repository.BittrexPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Optional;

@Service
public class PriceService {

    private final BinancePriceRepository binancePriceRepository;
    private final BittrexPriceRepository bittrexPriceRepository;

    @Autowired
    public PriceService(BinancePriceRepository binancePriceRepository, BittrexPriceRepository bittrexPriceRepository) {
        this.binancePriceRepository = binancePriceRepository;
        this.bittrexPriceRepository = bittrexPriceRepository;
    }


    public BinancePrice getMostRecentBinancePrices(Time time) {
        Optional<BinancePrice> binancePrice = binancePriceRepository.findFirstByOrderByIdDesc();
        if(binancePrice.isEmpty()) {
            throw new IllegalStateException("Binance Price Not Found!");
        }

        return binancePrice.get();
    }

    public BittrexPrice getMostRecentBittrexPrices(Time time) {
        Optional<BittrexPrice> bittrexPrice = bittrexPriceRepository.findFirstByOrderByIdDesc();
        if(bittrexPrice.isEmpty()) {
            throw new IllegalStateException("Bittrex Price Not Found!");
        }

        return bittrexPrice.get();
    }


}

package com.example.chainanalysis.Service;

import com.example.chainanalysis.Model.BinancePrice;
import com.example.chainanalysis.Repository.BinancePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {

    private final BinancePriceRepository binancePriceRepository;

    @Autowired
    public PriceService(BinancePriceRepository binancePriceRepository) {
        this.binancePriceRepository = binancePriceRepository;
    }


    public List<BinancePrice> getMostRecentPrices() {
        return new ArrayList<>();
    }


}

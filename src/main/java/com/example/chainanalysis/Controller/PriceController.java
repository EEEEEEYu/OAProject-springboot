package com.example.chainanalysis.Controller;

import com.example.chainanalysis.Model.BinancePrice;
import com.example.chainanalysis.Model.BittrexPrice;
import com.example.chainanalysis.Model.Exchange;
import com.example.chainanalysis.Service.ExchangeService;
import com.example.chainanalysis.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PriceController {
    private final PriceService priceService;
    private final ExchangeService exchangeService;

    @Autowired
    public PriceController(PriceService priceService, ExchangeService exchangeService) {
        this.priceService = priceService;
        this.exchangeService = exchangeService;
    }

    @GetMapping("/allExchanges")
    public List<Exchange> getAllExchanges() {
        return this.exchangeService.getAllExchanges();
    }

    @GetMapping("/getMostRecentBinancePrice")
    public BinancePrice getMostRecentBinancePrice() {
        return this.priceService.getMostRecentBinancePrices(Time.valueOf(LocalTime.now()));
    }
    @GetMapping("/getMostRecentBittrexPrice")
    public BittrexPrice getMostRecentBittrexPrice() {
        return this.priceService.getMostRecentBittrexPrices(Time.valueOf(LocalTime.now()));
    }

}

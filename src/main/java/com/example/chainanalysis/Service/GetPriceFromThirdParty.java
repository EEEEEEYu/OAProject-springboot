package com.example.chainanalysis.Service;

import com.example.chainanalysis.Model.Exchange;
import com.example.chainanalysis.Model.Price;
import com.example.chainanalysis.Repository.ExchangeRepository;
import com.example.chainanalysis.Repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BinanceObj {
    private String symbol;
    private Double bidPrice;
    private Double bidQty;
    private Double askPrice;
    private Double askQty;

    public BinanceObj() {}

    public BinanceObj(String symbol, Double bidPrice, Double bidQty, Double askPrice, Double askQty) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Double getBidQty() {
        return bidQty;
    }

    public void setBidQty(Double bidQty) {
        this.bidQty = bidQty;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
    }

    public Double getAskQty() {
        return askQty;
    }

    public void setAskQty(Double askQty) {
        this.askQty = askQty;
    }

    @Override
    public String toString() {
        return "BinanceObj{" +
                "symbol='" + symbol + '\'' +
                ", bidPrice=" + bidPrice +
                ", bidQty=" + bidQty +
                ", askPrice=" + askPrice +
                ", askQty=" + askQty +
                '}';
    }
}

class BittrexObj{
    private String symbol;
    private Double lastTradeRate;
    private Double bidRate;
    private Double askRate;

    public BittrexObj() {}

    public BittrexObj(String symbol, Double lastTradeRate, Double bidRate, Double askRate) {
        this.symbol = symbol;
        this.lastTradeRate = lastTradeRate;
        this.bidRate = bidRate;
        this.askRate = askRate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getLastTradeRate() {
        return lastTradeRate;
    }

    public void setLastTradeRate(Double lastTradeRate) {
        this.lastTradeRate = lastTradeRate;
    }

    public Double getBidRate() {
        return bidRate;
    }

    public void setBidRate(Double bidRate) {
        this.bidRate = bidRate;
    }

    public Double getAskRate() {
        return askRate;
    }

    public void setAskRate(Double askRate) {
        this.askRate = askRate;
    }

    @Override
    public String toString() {
        return "BittrexObj{" +
                "symbol='" + symbol + '\'' +
                ", lastTradeRate=" + lastTradeRate +
                ", bidRate=" + bidRate +
                ", askRate=" + askRate +
                '}';
    }
}

@Service
public class GetPriceFromThirdParty {
    private final ExchangeRepository exchangeRepository;
    private final PriceRepository priceRepository;
    private Map<String, String> urls;

    @Autowired
    public GetPriceFromThirdParty(ExchangeRepository exchangeRepository, PriceRepository priceRepository) {
        this.exchangeRepository = exchangeRepository;
        this.priceRepository = priceRepository;

        // Initialize all target urls
        List<Exchange> exchanges = this.exchangeRepository.findAll();
        this.urls = new HashMap<>();
        for(Exchange exc:exchanges) {
            this.urls.put(exc.getName(), exc.getApiURL());
        }
    }





}

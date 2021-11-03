package com.example.chainanalysis.Service.RestObjects;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

public class BinanceDataObj implements DataObj{
    private String symbol;
    private Double bidPrice;
    private Double bidQty;
    private Double askPrice;
    private Double askQty;

    public BinanceDataObj() {
        super();
    }

    public BinanceDataObj(String symbol, Double bidPrice, Double bidQty, Double askPrice, Double askQty) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
    }

    @Override
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

    @Override
    public Double getSellPrice() {
        return this.bidPrice;
    }

    @Override
    public Double getBuyPrice() {
        return this.askPrice;
    }
}


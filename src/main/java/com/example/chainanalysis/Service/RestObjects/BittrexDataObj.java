package com.example.chainanalysis.Service.RestObjects;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

public class BittrexDataObj implements DataObj{
    private String symbol;
    private Double lastTradeRate;
    private Double bidRate;
    private Double askRate;

    public BittrexDataObj() {}

    public BittrexDataObj(String symbol, Double lastTradeRate, Double bidRate, Double askRate) {
        this.symbol = symbol;
        this.lastTradeRate = lastTradeRate;
        this.bidRate = bidRate;
        this.askRate = askRate;
    }

    @Override
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


    @Override
    public Double getSellPrice() {
        return this.bidRate;
    }

    @Override
    public Double getBuyPrice() {
        return this.askRate;
    }
}

package com.example.chainanalysis.Service;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

class BittrexDataObj {
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

class BittrexCallable implements Callable<BittrexDataObj> {

    private final String url;

    public BittrexCallable(String url) {
        this.url = url;
    }

    @Override
    public BittrexDataObj call() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        BittrexDataObj bittrexDataObj = restTemplate.getForObject(this.url, BittrexDataObj.class);
        return bittrexDataObj;
    }
}
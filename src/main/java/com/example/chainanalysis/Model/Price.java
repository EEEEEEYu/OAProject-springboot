package com.example.chainanalysis.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Price {
    @Id
    @SequenceGenerator(
            name = "exchange_sequence",
            sequenceName = "exchange_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exchange_sequence"
    )
    private Long id;
    private Timestamp time;
    private Double BinanceBTCSellPrice;
    private Double BinanceBTCBuyPrice;
    private Double BinanceETHSellPrice;
    private Double BinanceETHBuyPrice;
    private Double BittrexBTCSellPrice;
    private Double BittrexBTCBuyPrice;
    private Double BittrexETHSellPrice;
    private Double BittrexETHBuyPrice;

    public Price() {}

    public Price(Long id, Timestamp time, Double binanceBTCSellPrice, Double binanceBTCBuyPrice, Double binanceETHSellPrice, Double binanceETHBuyPrice, Double bittrexBTCSellPrice, Double bittrexBTCBuyPrice, Double bittrexETHSellPrice, Double bittrexETHBuyPrice) {
        this.id = id;
        this.time = time;
        BinanceBTCSellPrice = binanceBTCSellPrice;
        BinanceBTCBuyPrice = binanceBTCBuyPrice;
        BinanceETHSellPrice = binanceETHSellPrice;
        BinanceETHBuyPrice = binanceETHBuyPrice;
        BittrexBTCSellPrice = bittrexBTCSellPrice;
        BittrexBTCBuyPrice = bittrexBTCBuyPrice;
        BittrexETHSellPrice = bittrexETHSellPrice;
        BittrexETHBuyPrice = bittrexETHBuyPrice;
    }

    public Price(Timestamp time, Double binanceBTCSellPrice, Double binanceBTCBuyPrice, Double binanceETHSellPrice, Double binanceETHBuyPrice, Double bittrexBTCSellPrice, Double bittrexBTCBuyPrice, Double bittrexETHSellPrice, Double bittrexETHBuyPrice) {
        this.time = time;
        BinanceBTCSellPrice = binanceBTCSellPrice;
        BinanceBTCBuyPrice = binanceBTCBuyPrice;
        BinanceETHSellPrice = binanceETHSellPrice;
        BinanceETHBuyPrice = binanceETHBuyPrice;
        BittrexBTCSellPrice = bittrexBTCSellPrice;
        BittrexBTCBuyPrice = bittrexBTCBuyPrice;
        BittrexETHSellPrice = bittrexETHSellPrice;
        BittrexETHBuyPrice = bittrexETHBuyPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Double getBinanceBTCSellPrice() {
        return BinanceBTCSellPrice;
    }

    public void setBinanceBTCSellPrice(Double binanceBTCSellPrice) {
        BinanceBTCSellPrice = binanceBTCSellPrice;
    }

    public Double getBinanceBTCBuyPrice() {
        return BinanceBTCBuyPrice;
    }

    public void setBinanceBTCBuyPrice(Double binanceBTCBuyPrice) {
        BinanceBTCBuyPrice = binanceBTCBuyPrice;
    }

    public Double getBinanceETHSellPrice() {
        return BinanceETHSellPrice;
    }

    public void setBinanceETHSellPrice(Double binanceETHSellPrice) {
        BinanceETHSellPrice = binanceETHSellPrice;
    }

    public Double getBinanceETHBuyPrice() {
        return BinanceETHBuyPrice;
    }

    public void setBinanceETHBuyPrice(Double binanceETHBuyPrice) {
        BinanceETHBuyPrice = binanceETHBuyPrice;
    }

    public Double getBittrexBTCSellPrice() {
        return BittrexBTCSellPrice;
    }

    public void setBittrexBTCSellPrice(Double bittrexBTCSellPrice) {
        BittrexBTCSellPrice = bittrexBTCSellPrice;
    }

    public Double getBittrexBTCBuyPrice() {
        return BittrexBTCBuyPrice;
    }

    public void setBittrexBTCBuyPrice(Double bittrexBTCBuyPrice) {
        BittrexBTCBuyPrice = bittrexBTCBuyPrice;
    }

    public Double getBittrexETHSellPrice() {
        return BittrexETHSellPrice;
    }

    public void setBittrexETHSellPrice(Double bittrexETHSellPrice) {
        BittrexETHSellPrice = bittrexETHSellPrice;
    }

    public Double getBittrexETHBuyPrice() {
        return BittrexETHBuyPrice;
    }

    public void setBittrexETHBuyPrice(Double bittrexETHBuyPrice) {
        BittrexETHBuyPrice = bittrexETHBuyPrice;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", time=" + time +
                ", BinanceBTCSellPrice=" + BinanceBTCSellPrice +
                ", BinanceBTCBuyPrice=" + BinanceBTCBuyPrice +
                ", BinanceETHSellPrice=" + BinanceETHSellPrice +
                ", BinanceETHBuyPrice=" + BinanceETHBuyPrice +
                ", BittrexBTCSellPrice=" + BittrexBTCSellPrice +
                ", BittrexBTCBuyPrice=" + BittrexBTCBuyPrice +
                ", BittrexETHSellPrice=" + BittrexETHSellPrice +
                ", BittrexETHBuyPrice=" + BittrexETHBuyPrice +
                '}';
    }
}

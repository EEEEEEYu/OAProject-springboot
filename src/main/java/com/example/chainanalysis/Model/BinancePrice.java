package com.example.chainanalysis.Model;

import javax.persistence.*;
import java.sql.Time;


@Entity
@Table
public class BinancePrice {
    @Id
    @SequenceGenerator(
            name = "binance_exchange_sequence",
            sequenceName = "binance_exchange_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "binance_exchange_sequence"
    )
    private Long id;
    private Time time;
    private Double BTCSellPrice;
    private Double BTCBuyPrice;
    private Double ETHSellPrice;
    private Double ETHBuyPrice;

    public BinancePrice() {}

    public BinancePrice(Long id, Time time, Double binanceBTCSellPrice, Double binanceBTCBuyPrice, Double binanceETHSellPrice, Double binanceETHBuyPrice, Double bittrexBTCSellPrice, Double bittrexBTCBuyPrice, Double bittrexETHSellPrice, Double bittrexETHBuyPrice) {
        this.id = id;
        this.time = time;
        BTCSellPrice = binanceBTCSellPrice;
        BTCBuyPrice = binanceBTCBuyPrice;
        ETHSellPrice = binanceETHSellPrice;
        ETHSellPrice = binanceETHBuyPrice;
    }

    public BinancePrice(Time time, Double binanceBTCSellPrice, Double binanceBTCBuyPrice, Double binanceETHSellPrice, Double binanceETHBuyPrice, Double bittrexBTCSellPrice, Double bittrexBTCBuyPrice, Double bittrexETHSellPrice, Double bittrexETHBuyPrice) {
        this.time = time;
        BTCSellPrice = binanceBTCSellPrice;
        BTCBuyPrice = binanceBTCBuyPrice;
        ETHSellPrice = binanceETHSellPrice;
        ETHBuyPrice = binanceETHBuyPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Double getBTCSellPrice() {
        return BTCSellPrice;
    }

    public void setBTCSellPrice(Double BTCSellPrice) {
        this.BTCSellPrice = BTCSellPrice;
    }

    public Double getBTCBuyPrice() {
        return BTCBuyPrice;
    }

    public void setBTCBuyPrice(Double BTCBuyPrice) {
        this.BTCBuyPrice = BTCBuyPrice;
    }

    public Double getETHSellPrice() {
        return ETHSellPrice;
    }

    public void setETHSellPrice(Double ETHSellPrice) {
        this.ETHSellPrice = ETHSellPrice;
    }

    public Double getETHBuyPrice() {
        return ETHBuyPrice;
    }

    public void setETHBuyPrice(Double ETHBuyPrice) {
        this.ETHBuyPrice = ETHBuyPrice;
    }

    @Override
    public String toString() {
        return "BinancePrice{" +
                "id=" + id +
                ", time=" + time +
                ", BTCSellPrice=" + BTCSellPrice +
                ", BTCBuyPrice=" + BTCBuyPrice +
                ", ETHSellPrice=" + ETHSellPrice +
                ", ETHBuyPrice=" + ETHBuyPrice +
                '}';
    }
}

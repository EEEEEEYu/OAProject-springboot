package com.example.chainanalysis.Model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table
public class BittrexPrice {
    @Id
    @SequenceGenerator(
            name = "bittrex_exchange_sequence",
            sequenceName = "bittrex_exchange_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bittrex_exchange_sequence"
    )
    private Long id;
    private Time time;
    private Double BTCSellPrice;
    private Double BTCBuyPrice;
    private Double ETHSellPrice;
    private Double ETHBuyPrice;

    public BittrexPrice() {}

    public BittrexPrice(Long id, Time time, Double BTCSellPrice, Double BTCBuyPrice, Double ETHSellPrice, Double ETHBuyPrice) {
        this.id = id;
        this.time = time;
        this.BTCSellPrice = BTCSellPrice;
        this.BTCBuyPrice = BTCBuyPrice;
        this.ETHSellPrice = ETHSellPrice;
        this.ETHBuyPrice = ETHBuyPrice;
    }

    public BittrexPrice(Time time, Double BTCSellPrice, Double BTCBuyPrice, Double ETHSellPrice, Double ETHBuyPrice) {
        this.time = time;
        this.BTCSellPrice = BTCSellPrice;
        this.BTCBuyPrice = BTCBuyPrice;
        this.ETHSellPrice = ETHSellPrice;
        this.ETHBuyPrice = ETHBuyPrice;
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
        return "BittrexPrice{" +
                "id=" + id +
                ", time=" + time +
                ", BTCSellPrice=" + BTCSellPrice +
                ", BTCBuyPrice=" + BTCBuyPrice +
                ", ETHSellPrice=" + ETHSellPrice +
                ", ETHBuyPrice=" + ETHBuyPrice +
                '}';
    }
}

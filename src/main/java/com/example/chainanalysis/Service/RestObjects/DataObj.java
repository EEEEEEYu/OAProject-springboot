package com.example.chainanalysis.Service.RestObjects;

/***
 * This interface provides a set of unified methods to get
 * buy/sell price from Resttemplate return obj
 */
public interface DataObj {
    public String getSymbol();
    public Double getSellPrice();
    public Double getBuyPrice();
}

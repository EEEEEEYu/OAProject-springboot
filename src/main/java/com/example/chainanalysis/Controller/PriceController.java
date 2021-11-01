package com.example.chainanalysis.Controller;

import com.example.chainanalysis.Model.Price;
import com.example.chainanalysis.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceController {
    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/mostRecentPrice")
    public Price getMostRecentPrice() {
        return this.priceService.getMostRecentPrice();
    }

    @GetMapping("/mostRecent60Prices")
    public List<Price> getMostRecent60Price() {
        return this.priceService.getMostRecent60Prices();
    }
}

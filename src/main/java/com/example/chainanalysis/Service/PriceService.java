package com.example.chainanalysis.Service;

import com.example.chainanalysis.Model.Price;
import com.example.chainanalysis.Repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price getMostRecentPrice() {
        return new Price();
    }

    public List<Price> getMostRecent60Prices() {
        return new ArrayList<>();
    }


}

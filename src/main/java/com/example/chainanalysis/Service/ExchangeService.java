package com.example.chainanalysis.Service;

import com.example.chainanalysis.Model.Exchange;
import com.example.chainanalysis.Repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;

    @Autowired
    public ExchangeService(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    // Get all exchanges data
    public List<Exchange> getAllExchanges() {
        return exchangeRepository.findAll();
    }
}

package com.example.chainanalysis.Config;

import com.example.chainanalysis.Model.Exchange;
import com.example.chainanalysis.Repository.ExchangeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration("ExchangeConfig")
public class ExchangeConfig {
    // Add initial exchange information
    @Bean
    CommandLineRunner commandLineRunner(ExchangeRepository repository) {
        return args -> {
            Exchange Binance = new Exchange(
                    "Binance",
                    "https://api.binance.com/api/v3/ticker/bookTicker?symbol={}",
                    "BTCUSDT,ETHUSDT"
            );

            Exchange Bittrex = new Exchange(
                    "Bittrex",
                    "https://api.bittrex.com/v3/markets/{}/ticker",
                    "BTC-USDT,ETH-USDT"
            );

            repository.saveAll(
                    List.of(Binance, Bittrex)
            );
        };
    }
}

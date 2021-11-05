package com.example.chainanalysis.Repository;

import com.example.chainanalysis.Model.BinancePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Repository("BinancePriceRepository")
public interface BinancePriceRepository extends JpaRepository<BinancePrice, Long> {
    Optional<BinancePrice> findFirstByOrderByIdDesc();
}

package com.example.chainanalysis.Repository;

import com.example.chainanalysis.Model.BinancePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("BinancePriceRepository")
public interface BinancePriceRepository extends JpaRepository<BinancePrice, Long> {

}

package com.example.chainanalysis.Repository;

import com.example.chainanalysis.Model.BittrexPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("BittrexPriceRepository")
public interface BittrexPriceRepository extends JpaRepository<BittrexPrice, Long> {
}

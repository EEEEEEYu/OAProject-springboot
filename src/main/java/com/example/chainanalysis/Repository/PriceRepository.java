package com.example.chainanalysis.Repository;

import com.example.chainanalysis.Model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PriceRepository")
public interface PriceRepository extends JpaRepository<Price, Long> {
}

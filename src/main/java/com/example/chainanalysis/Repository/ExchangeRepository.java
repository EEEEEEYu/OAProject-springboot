package com.example.chainanalysis.Repository;

import com.example.chainanalysis.Model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ExchangeRepository")
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

}

package br.com.willi.williMeter.repository;

import br.com.willi.williMeter.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}

package br.com.willi.williMeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.willi.williMeter.models.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}

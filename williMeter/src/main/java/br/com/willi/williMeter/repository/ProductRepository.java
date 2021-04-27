package br.com.willi.williMeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.willi.williMeter.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

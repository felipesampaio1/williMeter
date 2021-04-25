package br.com.willi.williMeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.willi.williMeter.models.UserOrder;

public interface OrderRepository extends JpaRepository<UserOrder, String> {

}

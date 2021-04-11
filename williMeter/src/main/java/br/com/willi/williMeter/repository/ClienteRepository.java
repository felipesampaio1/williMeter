package br.com.willi.williMeter.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.willi.williMeter.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
	
	
}

package br.com.willi.williMeter.repository;

import br.com.willi.williMeter.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
	
	
}

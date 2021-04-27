package br.com.willi.williMeter.repository;

import br.com.willi.williMeter.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findById(long id);
}

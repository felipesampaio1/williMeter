package br.com.willi.williMeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.willi.williMeter.models.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findById(long id);
}

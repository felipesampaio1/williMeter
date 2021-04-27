package br.com.willi.williMeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.willi.williMeter.models.Tap;


public interface TapRepository extends JpaRepository<Tap, Long> {
}

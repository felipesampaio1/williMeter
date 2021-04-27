package br.com.willi.williMeter.repository;

import br.com.willi.williMeter.models.Tap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TapRepository extends JpaRepository<Tap, Long> {
}

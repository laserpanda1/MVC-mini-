package com.example.AircraftPositions;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AircraftRepository extends ReactiveCrudRepository<Aircraft, Long> {

    public Flux<Aircraft> findAircraftByReg(String reg);
}

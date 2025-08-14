package com.example.AircraftPositions;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends ReactiveCrudRepository<Aircraft, Long> {
}

package com.example.AircraftPositions;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PositionService {

    private AircraftRepository repository;
    private WebClient client = WebClient.create(
            "http://localhost:7634/aircraft");

    public PositionService(AircraftRepository repository) {
        this.repository = repository;
    }

    public Flux<Aircraft> getAllAircraft() {
        return repository.deleteAll()
                .thenMany(client.get()
                        .retrieve()
                        .bodyToFlux(Aircraft.class)
                        .filter(plane -> !plane.getReg().isEmpty()))
                .flatMap(repository::save)
                .thenMany(repository.findAll());
    }

    public Mono<Aircraft> getAircraftById(Long id) {
        return repository.findById(id);
    }

    public Flux<Aircraft> getAircraftByReg(String reg) {
        return repository.findAircraftByReg(reg);
    }

}

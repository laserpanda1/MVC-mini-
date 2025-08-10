package com.example.AircraftPositions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequiredArgsConstructor
public class PositionController {

    WebClient client =
            WebClient.create("http://localhost:7623/aircraft");

    private AircraftRepository aircraftRepository;

    public PositionController(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @GetMapping("/aircraft")
    public String getCurrentAircraftPosition(Model model) {
        aircraftRepository.deleteAll();

        client.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(ac -> !ac.getReg().isEmpty())
                .toStream()
                .forEach(aircraftRepository::save);

        model.addAttribute("currentPositions", aircraftRepository.findAll());
        return "positions";
    }

}

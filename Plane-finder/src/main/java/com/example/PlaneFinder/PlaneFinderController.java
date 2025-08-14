package com.example.PlaneFinder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Controller
public class PlaneFinderController {

    private PlaneFinderService service;

    public PlaneFinderController(PlaneFinderService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/aircraft")
    public Flux<Aircraft> getCurrentAircraft() throws IOException {
        return service.getAircraft();
    }
}

package com.example.PlaneFinder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class PlaneFinderController {

    private PlaneFinderService service;

    public PlaneFinderController(PlaneFinderService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/aircraft")
    public Iterable<Aircraft> getCurrentAircraft() throws IOException {
        return service.getAircraft();
    }
}

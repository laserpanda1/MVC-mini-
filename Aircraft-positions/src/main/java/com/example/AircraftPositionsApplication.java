package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;
import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class AircraftPositionsApplication {

    public static void main(String[] args) {
        Hooks.onOperatorDebug(); // <- очень важно , помогает найти ошибку , без этого оператора найти ошибку будет намного сложнее
        ReactorDebugAgent.init(); // <- делает почти то же самое , но не тормозит мой проект
        SpringApplication.run(AircraftPositionsApplication.class, args);
    }

}


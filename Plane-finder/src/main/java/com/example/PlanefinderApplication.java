package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class PlanefinderApplication {

    public static void main(String[] args) {
        Hooks.onOperatorDebug(); // <- очень важно , помогает найти ошибку , без этого оператора найти ошибку будет намного сложнее
        SpringApplication.run(PlanefinderApplication.class, args);
    }

}

package com.esprit.examen_blanc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExamenBlancApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenBlancApplication.class, args);
    }

}

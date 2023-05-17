package com.example.strongtestassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StrongTestAssignmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StrongTestAssignmentApplication.class, args);
    }

}

package com.example.airodata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.airodata"})
public class AiroDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiroDataApplication.class, args);
    }

}

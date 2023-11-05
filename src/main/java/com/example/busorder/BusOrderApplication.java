package com.example.busorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BusOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusOrderApplication.class, args);
        System.out.println("run app");

    }

}

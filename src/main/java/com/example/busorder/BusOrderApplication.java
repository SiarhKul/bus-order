package com.example.busorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusOrderApplication.class, args);

        System.out.println("App has been launched");
    }

}

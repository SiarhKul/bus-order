package com.example.busorder;

import com.example.busorder.enums.BookingStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusOrderApplication {
    //todo create mapper
    // todo create stations
    public static void main(String[] args) {
        SpringApplication.run(BusOrderApplication.class, args);
        System.out.println("run test");

        System.out.println(  BookingStatus.valueOf("FUTURE"));

    }

}

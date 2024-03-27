package com.example.busorder;

import com.example.busorder.config.producer.KafkaRouteProducer;
import com.example.busorder.service.RouteServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BusOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusOrderApplication.class, args);
        System.out.println("The app is running...");
    }

/*    @Bean
    public CommandLineRunner commandLineRunner(RouteServiceImpl routeService,
                                               KafkaRouteProducer kafkaRouteProducer) {

        return args -> {
            routeService.getAllRoutes().forEach(kafkaRouteProducer::sendRoute);
            System.out.println("Send message to the Kafka topic");
        };
    }*/

}




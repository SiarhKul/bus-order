package com.example.busorder.config.producer;

import com.example.busorder.constans.KafkaConstants;
import com.example.busorder.models.entities.Route;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaRouteProducer {

    private final KafkaTemplate<String, Route> kafkaTemplate;
    public  void sendRoute(Route route){

        Message<Route>  message = MessageBuilder
                .withPayload(route)
                .setHeader(KafkaHeaders.TOPIC, KafkaConstants.ROUTE_TOPIC)
                .build();

        log.info("Producing route: " + route);

        kafkaTemplate.send(message);
    }

}

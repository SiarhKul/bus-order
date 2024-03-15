package com.example.busorder.config;

import com.example.busorder.constans.KafkaConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic RouteTopic(){
        return TopicBuilder
                .name(KafkaConstants.ROUTE_TOPIC)
                .build();
    }
}

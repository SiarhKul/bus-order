package com.example.busorder.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(
        title = "Order bus",
        description = "Order Bus API"))
@Configuration
public class GlobalConfig {

}

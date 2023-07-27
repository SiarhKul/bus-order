package com.example.busorder.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(
        title = "Data Enrichment service",
        description = "Data Enrichment API"))
@Configuration
public class GlobalConfig {
    public static final String DEFAULT_API_SECURITY_SCHEMA_NAME = "JWT";
}

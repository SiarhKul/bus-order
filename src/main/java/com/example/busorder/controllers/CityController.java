package com.example.busorder.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "City")
@RestController()
@RequestMapping("/api")
public class CityController {

    @ApiResponse(responseCode = "200", description = "Cities are returned")
    @Operation(summary = "city", description = "Get available cities")
    @GetMapping("/city")
    public String getAllCities() {
        return "Minsk";
    }
}

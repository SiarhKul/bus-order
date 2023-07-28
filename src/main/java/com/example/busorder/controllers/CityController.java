package com.example.busorder.controllers;

import com.example.busorder.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "City")
@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @ApiResponse(responseCode = "200", description = "Cities are returned")
    @Operation(summary = "city", description = "Get available cities")
    @GetMapping("/city")
    public String getAllCities() {
        return cityService.getCity();

    }
}

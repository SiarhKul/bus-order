package com.example.busorder.controllers;

import com.example.busorder.models.entities.City;
import com.example.busorder.service.serviceInterfaces.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "City")
@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class CityController {

    private final CityService cityServiece;

    @ApiResponse(responseCode = "200", description = "Cities are returned")
    @Operation(summary = "city", description = "Get available cities")
    @GetMapping("/city")
    public List<City> getAllCities() {
        return cityServiece.getAllCity();
    }

    @ApiResponse(responseCode = "200", description = "City name is returned[Admin]")
    @Operation(summary = "name-city[Admin]", description = "description name-city")
    @GetMapping("/city-name/{cityId}")
    public City getCityById(@PathVariable("cityId") Integer cityId) {
        return cityServiece.getCityById(cityId);
    }
}

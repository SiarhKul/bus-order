package com.example.busorder.controllers;

import com.example.busorder.models.entities.City;
import com.example.busorder.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "City")
@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @ApiResponse(responseCode = "200", description = "Cities are returned")
    @Operation(summary = "city", description = "Get available cities")
    @GetMapping("/city")
    public List<City> getAllCities() {
        return cityService.getAllCity();
    }


    @ApiResponse(responseCode = "200", description = "City name is returened")
    @Operation(summary = "name-city", description = "description name-city")
    @GetMapping("/city-name/{cityId}")
    public String getCityById(@PathVariable("cityId") String cityId  ){
        return cityService.getCityById(cityId);
    }

}

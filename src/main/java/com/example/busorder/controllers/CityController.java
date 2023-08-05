package com.example.busorder.controllers;

import com.example.busorder.models.entities.City;
import com.example.busorder.service.CityService;
import com.example.busorder.util.ErrorResponse;
import com.example.busorder.util.CityNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @ApiResponse(responseCode = "200", description = "City name is returned")
    @Operation(summary = "name-city", description = "description name-city")
    @GetMapping("/city-name/{cityId}")
    public City getCityById(@PathVariable("cityId") Integer cityId) {
        return cityServiece.getCityById(cityId);
    }


    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleCityNotFoundExceptions(CityNotFoundException exception) {

        ErrorResponse test = ErrorResponse.builder()
                .message("error text message")
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(test, HttpStatus.NOT_FOUND);

    }
}

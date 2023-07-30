package com.example.busorder.controllers;


import com.example.busorder.models.entities.Route;
import com.example.busorder.service.RouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Routes")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RouteController {

    private final RouteService routeService;


    @ApiResponse(responseCode = "200", description = "Available user routes")
    @Operation(summary = "route", description = "Route destination")
    @GetMapping("/routes")
    List<Route> getAllRoute() {
        return routeService.getAllRoutes();
    }
}

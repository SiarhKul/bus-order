package com.example.busorder.controllers;


import com.example.busorder.models.dto.RouteRequestDTO;
import com.example.busorder.models.entities.Route;
import com.example.busorder.service.RouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Routes")
@RestController
@RequestMapping("/api/routes")
@AllArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @ApiResponse(responseCode = "200", description = "Available user routes")
    @Operation(summary = "route", description = "Route destination")
    @GetMapping()
    List<Route> getAllRoute() {
        return routeService.getAllRoutes();
    }

    @ApiResponse(responseCode = "200", description = "Route was created")
    @Operation(summary = "Create route based on list of city", description = "Return a created Route")
    @PostMapping
    Route createRoute(@RequestBody RouteRequestDTO routeRequestDTO) {
        return routeService.createRoute(routeRequestDTO);
    }


}

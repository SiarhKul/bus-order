package com.example.busorder.controllers;


import com.example.busorder.models.entities.Route;
import com.example.busorder.service.RouteService;
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

    @GetMapping("/routes")
    List<Route> getAllRoute() {
        return routeService.getAllRoutes();
    }
}

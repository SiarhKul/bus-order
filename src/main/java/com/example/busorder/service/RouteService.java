package com.example.busorder.service;

import com.example.busorder.models.dto.RouteRequestDTO;
import com.example.busorder.models.entities.Route;

import java.util.List;

public interface RouteService {
    List<Route> getAllRoutes();

    Route createRoute(RouteRequestDTO routeRequestDTO);

}





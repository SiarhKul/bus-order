package com.example.busorder.service;

import com.example.busorder.models.dto.RouteRequestDTO;
import com.example.busorder.models.entities.Route;
import com.example.busorder.repository.RouteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Route createRoute(RouteRequestDTO routeRequestDTO) {

        Route buildedRoute = Route.builder()
                .destination_city(routeRequestDTO.getDestinationCity())
                .departure_city(routeRequestDTO.getDepartureCity())
                .build();

        routeRepository.save(buildedRoute);

//        return Route.builder().id(1)
//                .departure_city("Minsk")
//                .destination_city("Vitebsk")
//                .build();
    }
}

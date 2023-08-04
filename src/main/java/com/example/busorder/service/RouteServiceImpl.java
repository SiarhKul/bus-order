package com.example.busorder.service;

import com.example.busorder.mapper.RouteMapper;
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
    private final RouteMapper routeMapper;

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Route createRoute(RouteRequestDTO routeRequestDTO) {

        Route route = routeMapper.routeRequestDTOtoRoute(routeRequestDTO);
        return routeRepository.save(route);
    }
}

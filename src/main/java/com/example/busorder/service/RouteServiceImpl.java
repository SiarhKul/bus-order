package com.example.busorder.service;

import com.example.busorder.exceptions.InvalidCombinationException;
import com.example.busorder.mapper.RouteMapper;
import com.example.busorder.models.dto.RouteRequestDTO;
import com.example.busorder.models.entities.Route;
import com.example.busorder.repository.RouteRepository;
import com.example.busorder.exceptions.RecordExistsInTableException;
import com.example.busorder.service.serviceInterfaces.RouteService;
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
    public Route createRoute(RouteRequestDTO routeRequestDTO) throws RecordExistsInTableException {
        verificationRecordInDB(routeRequestDTO);

        Route route = routeMapper.routeRequestDTOtoRoute(routeRequestDTO);

        return routeRepository.save(route);
    }

    private void verificationRecordInDB(RouteRequestDTO routeRequestDTO) {
        String departureCity = routeRequestDTO.getDepartureCity();
        String destinationCity = routeRequestDTO.getDestinationCity();
        Boolean hasDoubleRoutes = routeRepository
                .checkDoubles(departureCity, destinationCity);

        if (hasDoubleRoutes) {
            throw new RecordExistsInTableException("The record exists in DB");
        }

        if (departureCity.equals(destinationCity)) {
            throw new InvalidCombinationException("Invalid combination of cities");
        }

    }
}

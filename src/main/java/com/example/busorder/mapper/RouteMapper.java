package com.example.busorder.mapper;

import com.example.busorder.models.dto.RouteRequestDTO;
import com.example.busorder.models.entities.Route;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RouteMapper {


    @Mapping(target = "departure_city", source = "departureCity")
    @Mapping(target = "destination_city", source = "destinationCity")
    Route routeRequestDTOtoRoute(RouteRequestDTO routeRequestDTO);
}

package com.example.busorder.mapper;

import com.example.busorder.models.dto.ScheduleDTO;
import com.example.busorder.models.entities.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScheduleMapper {

    @Mapping(target = "departureCity", source = "departure_city")
    @Mapping(target = "destinationCity", source = "destination_city")
    ScheduleDTO ScheduleRsToScheduleDTO(List<Schedule> schedules);

}

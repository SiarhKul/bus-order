package com.example.busorder.mapper;

import com.example.busorder.models.dto.ScheduleDTO;
import com.example.busorder.models.entities.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScheduleMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "amountPassengersTest", source = "amountPassengers")
    @Mapping(target = "dep", source = "route.departure_city")
    @Mapping(target = "dest", source = "route.destination_city")
    ScheduleDTO toScheduleDTO(Schedule schedule);
    List<ScheduleDTO> toScheduleDTO(List<Schedule> schedules);
}

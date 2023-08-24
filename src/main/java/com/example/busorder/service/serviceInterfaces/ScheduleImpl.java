package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.dto.TripDTO;
import com.example.busorder.models.entities.Schedule;
import com.example.busorder.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getSchedule(TripDTO tripDTO) {
        String departureCity = tripDTO.getDepartureCity();
        String destinationCity = tripDTO.getDestinationCity();

        List<Schedule> schedules = scheduleRepository.getSchedule(departureCity, destinationCity);

        return schedules;
    }
}

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

        return scheduleRepository.getSchedule(tripDTO.getDate());
//        return scheduleRepository.findAll();
    }
}

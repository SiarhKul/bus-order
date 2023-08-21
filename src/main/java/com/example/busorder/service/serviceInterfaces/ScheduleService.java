package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.dto.TripDTO;
import com.example.busorder.models.entities.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getSchedule(TripDTO tripDTO);
}

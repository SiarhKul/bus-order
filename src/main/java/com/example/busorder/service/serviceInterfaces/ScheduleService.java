package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.dto.ScheduleDTO;
import com.example.busorder.models.dto.TripDTO;
import com.example.busorder.models.entities.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    List<ScheduleDTO> getSchedule(TripDTO tripDTO);
}

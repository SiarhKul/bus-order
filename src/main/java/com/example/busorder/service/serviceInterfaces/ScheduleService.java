package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.dto.ScheduleResponseDTO;
import com.example.busorder.models.dto.TripDTO;

public interface ScheduleService {
    ScheduleResponseDTO getSchedule(TripDTO tripDTO);
}

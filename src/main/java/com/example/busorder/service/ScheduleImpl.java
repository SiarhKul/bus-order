package com.example.busorder.service;

import com.example.busorder.mapper.ScheduleMapper;
import com.example.busorder.models.dto.ScheduleResponseDTO;
import com.example.busorder.models.dto.ScheduleDTO;
import com.example.busorder.models.dto.TripDTO;
import com.example.busorder.models.entities.BusStop;
import com.example.busorder.models.entities.Schedule;
import com.example.busorder.repository.ScheduleRepository;
import com.example.busorder.repository.StationRepository;
import com.example.busorder.service.serviceInterfaces.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    private final StationRepository stationRepository;

    @Override
    public ScheduleResponseDTO getSchedule(TripDTO tripDTO) {
        String departureCity = tripDTO.getDepartureCity();
        String destinationCity = tripDTO.getDestinationCity();

        List<Schedule> schedules = scheduleRepository
                .getSchedule(departureCity, destinationCity);

        List<ScheduleDTO> scheduleDTOS = scheduleMapper
                .toScheduleDTO(schedules);

        List<BusStop> busStopsDepartureCity = stationRepository.findAllStationByCityId(departureCity);
        List<BusStop> busStopsDestination = stationRepository.findAllStationByCityId(destinationCity);

        ScheduleResponseDTO connectionResponseDTO = ScheduleResponseDTO
                .builder()
                .schedule(scheduleDTOS)
                .busStopsDepartureCity(busStopsDepartureCity)
                .busStopsDestinationCity(busStopsDestination)
                .build();

        return connectionResponseDTO;
    }


}

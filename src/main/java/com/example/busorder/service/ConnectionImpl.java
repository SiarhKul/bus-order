package com.example.busorder.service;

import com.example.busorder.mapper.ScheduleMapper;
import com.example.busorder.models.dto.ConnectionResponseDTO;
import com.example.busorder.models.dto.ScheduleDTO;
import com.example.busorder.models.dto.TripDTO;
import com.example.busorder.models.entities.BusStop;
import com.example.busorder.models.entities.Schedule;
import com.example.busorder.repository.ScheduleRepository;
import com.example.busorder.repository.StationRepository;
import com.example.busorder.service.serviceInterfaces.ConnectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConnectionImpl implements ConnectionService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    private final StationRepository stantionRepository;

    @Override
    public ConnectionResponseDTO getConnection(TripDTO tripDTO) {
        String departureCity = tripDTO.getDepartureCity();
        String destinationCity = tripDTO.getDestinationCity();

        List<Schedule> schedules = scheduleRepository
                .getSchedule(departureCity, destinationCity);
        List<ScheduleDTO> scheduleDTOS = scheduleMapper
                .toScheduleDTO(schedules);

        List<BusStop> busStopsDepartureCity = stantionRepository.findAllStationByCityId(departureCity);
        List<BusStop> busStopsDestination = stantionRepository.findAllStationByCityId(destinationCity);
        System.out.println(busStopsDestination);
        System.out.println(busStopsDepartureCity);


        ConnectionResponseDTO connectionResponseDTO = ConnectionResponseDTO
                .builder()
                .schedule(scheduleDTOS)
                .busStopsDepartureCity(busStopsDepartureCity)
                .busStopsDestinationCity(busStopsDestination)
                .build();

        return connectionResponseDTO;
    }


}

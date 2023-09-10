package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.mapper.ScheduleMapper;
import com.example.busorder.models.dto.ConnectionResponseDTO;
import com.example.busorder.models.dto.ScheduleDTO;
import com.example.busorder.models.dto.TripDTO;
import com.example.busorder.models.entities.Schedule;
import com.example.busorder.models.entities.BusStop;
import com.example.busorder.repository.ScheduleRepository;
import com.example.busorder.repository.StantionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    private final StantionRepository stantionRepository;

    @Override
    public List<ScheduleDTO> getSchedule(TripDTO tripDTO) {
        String departureCity = tripDTO.getDepartureCity();
        String destinationCity = tripDTO.getDestinationCity();

        List<Schedule> schedules = scheduleRepository
                .getSchedule(departureCity, destinationCity);
        List<ScheduleDTO> scheduleDTOS = scheduleMapper
                .toScheduleDTO(schedules);

        List<BusStop> busStopsDepartureCity = stantionRepository.findAllStantionByCityId(departureCity);
        List<BusStop> busStopsDestination = stantionRepository.findAllStantionByCityId(destinationCity);
        System.out.println(busStopsDestination);
        System.out.println(busStopsDepartureCity);


        ConnectionResponseDTO connectionResponseDTO = ConnectionResponseDTO
                .builder()
                .scheduleDTO(scheduleDTOS)
                .busStopsDepartureCity(busStopsDepartureCity)
                .busStopsDestinationCity(busStopsDestination)
                .build();
        System.out.println(connectionResponseDTO);

        return scheduleDTOS;
    }


}

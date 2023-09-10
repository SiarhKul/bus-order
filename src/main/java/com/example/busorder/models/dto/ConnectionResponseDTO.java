package com.example.busorder.models.dto;


import com.example.busorder.models.entities.BusStop;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.List;


@Builder
@Data()
public class ConnectionResponseDTO {
private List<ScheduleDTO> scheduleDTO;
private List<BusStop> busStopsDepartureCity;
private List<BusStop> busStopsDestinationCity;

}

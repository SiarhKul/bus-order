package com.example.busorder.models.dto;


import com.example.busorder.models.entities.BusStop;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
@Data
public class ScheduleResponseDTO {
private List<ScheduleDTO> schedule;
private List<BusStop> busStopsDepartureCity;
private List<BusStop> busStopsDestinationCity;

}

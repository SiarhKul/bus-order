package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.dto.TripDTO;
import com.example.busorder.models.entities.Schedule;
import com.example.busorder.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class ScheduleImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getSchedule(TripDTO tripDTO) {

        Schedule build = Schedule.builder().id(100).amountPassengers(100).build();
        List<Schedule> build1 = List.of(build);
//        LocalDate localDate = LocalDate.parse("2024-02-01");
//        TripDTO build = TripDTO.builder().date(localDate).build();

        List<ResultSet> schedule = scheduleRepository.getSchedule(1);

        return build1;

//        return scheduleRepository.findAll();
    }
}

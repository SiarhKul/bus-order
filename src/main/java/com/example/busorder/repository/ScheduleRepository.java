package com.example.busorder.repository;

import com.example.busorder.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query(value = "select s from Schedule s " +
            "where s.route.departure_city=:departureCity and s.route.destination_city=:destinationCity")
    List<Schedule> getSchedule(String departureCity, String destinationCity);

}

package com.example.busorder.repository;

import com.example.busorder.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Query(value = "select s.date, s.route from Schedule s join Route r on r.id = s.id where s.date>?1 ")
    List<Schedule> getSchedule(LocalDate date);
}

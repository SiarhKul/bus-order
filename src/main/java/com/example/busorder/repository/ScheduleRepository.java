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

/*    @Query(value = "select s.date from Schedule s " +
            "join Route r on r.id = s.id " +
            "where s.amountPassengers=?1")
    List<LocalDate> getSchedule(Integer people);*/


    @Query(value = "select s.date from Schedule s " +
            "join Route r on r.id = s.id " +
            "where s.amount_passengers=?1", nativeQuery = true)
    List<ResultSet> getSchedule(Integer people);

}

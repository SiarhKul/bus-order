package com.example.busorder.repository;

import com.example.busorder.models.entities.BusStop;
import com.example.busorder.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<BusStop, Integer> {

    @Query(value = "select bs from BusStop bs where bs.city.name=:city")
    List<BusStop> findAllStationByCityId(String city );
}
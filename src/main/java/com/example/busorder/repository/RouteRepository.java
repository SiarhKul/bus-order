package com.example.busorder.repository;

import com.example.busorder.models.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {


    @Query(
            value = "SELECT r.departure_city " +
                    "FROM Route r " +
                    "GROUP BY r.departure_city,r.destination_city " +
                    "HAVING count(r)>1"
    )
    List<ResultSet> checkDoubles();
}

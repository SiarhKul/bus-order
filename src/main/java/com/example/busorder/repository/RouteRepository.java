package com.example.busorder.repository;

import com.example.busorder.models.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

    @Query(value =
            "SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END " +
                    "FROM Route r " +
                    "WHERE r.departure_city = ?1 AND r.destination_city = ?2"
    )
    Boolean checkDoubles(String departureCity, String destinationCity);

/*
@Query(
            value = "SELECT 1 FROM Route r " +
                    "WHERE r.departure_city = ?1 AND r.destination_city = ?2"
    )
@Query(
            value = "SELECT r.departure_city " +
                    "FROM Route r " +
                    "GROUP BY r.departure_city,r.destination_city " +
                    "HAVING count(r)>1"
    )
*/

}

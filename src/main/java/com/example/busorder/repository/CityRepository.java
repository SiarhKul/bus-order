package com.example.busorder.repository;

import com.example.busorder.models.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select c.name from City c where c.id=?1")
    String getCityByName(String cityId);

}

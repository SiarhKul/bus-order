package com.example.busorder.service;

import com.example.busorder.models.entities.City;

import java.util.List;

public interface CityService {
    List<City> getAllCity();

    String getCityById(String cityId);
}

package com.example.busorder.service;

import com.example.busorder.models.entities.City;
import com.example.busorder.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

}

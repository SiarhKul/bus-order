package com.example.busorder.service;

import com.example.busorder.models.entities.City;
import com.example.busorder.repository.CityRepository;
import com.example.busorder.exceptions.CityNotFoundException;
import com.example.busorder.service.serviceInterfaces.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Integer cityId) {

        Optional<City> city = cityRepository.findById(cityId);

        return city.orElseThrow(CityNotFoundException::new);

    }


}

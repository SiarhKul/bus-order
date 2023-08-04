package com.example.busorder.service;

import com.example.busorder.models.entities.City;
import com.example.busorder.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public String getCityById(String cityId) {
        return cityRepository.getCityByName(cityId);
    }

/*    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    public String getCityById(String cityId) {
        return cityRepository.getCityByName(cityId);
    }*/

}

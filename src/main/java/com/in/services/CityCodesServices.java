package com.in.services;

import com.in.model.CityCodes;
import com.in.repo.CityCodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CityCodesServices {
    @Autowired
    private CityCodesRepository cityCodesRepository;

    public List<CityCodes> findAllCities(){
        return cityCodesRepository.findAll();
    }

    public Optional<CityCodes> findCityByCode(String name){
        return cityCodesRepository.findById(name);
    }

    public Optional<CityCodes> findCityCodeByName(String name){
        return cityCodesRepository.findByName(name);
    }
}

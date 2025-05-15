package com.in.services;

import com.in.model.Airports;
import com.in.repo.AirportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AirportsServices {
    @Autowired
    private AirportsRepository airportsRepository;

    public Optional<Airports> findAirportsByCode(String code){
        return airportsRepository.findById(code);
    }

    public List<Airports> findAllAirports(){
        return airportsRepository.findAll();
    }

    public Optional<Airports> findAirportsByName(String name){
        return airportsRepository.findByName(name);
    }

}

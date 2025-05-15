package com.in.Controllers;

import com.in.model.CityCodes;
import com.in.services.CityCodesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city/")
public class CityCodesControllers {
    @Autowired
    private CityCodesServices cityCodesServices;
    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<CityCodes> findAllCityCodes(){
        return cityCodesServices.findAllCities();
    }
    @GetMapping("{code}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CityCodes> findCityByCode(@PathVariable String code){
        return cityCodesServices.findCityByCode(code);
    }
    @GetMapping("by/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CityCodes> findCityByName(@PathVariable String name){
        return cityCodesServices.findCityCodeByName(name);
    }

}

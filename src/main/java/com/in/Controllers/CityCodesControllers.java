package com.in.Controllers;

import com.in.model.CityCodes;
import com.in.services.CityCodesServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


//    private Logger logger= LoggerFactory.getLogger(CityCodesControllers.class);

    private static final Logger logger=LoggerFactory.getLogger(CityCodesControllers.class);

    /**
     *
     * @return all citiescode
     */
    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<CityCodes> findAllCityCodes(){
        logger.info("get all city");
        return cityCodesServices.findAllCities();
    }

    /**
     *
     *
     * @param code  for find all city by code
     * @return all city by city code
     */
    @GetMapping("{code}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CityCodes> findCityByCode(@PathVariable String code){
        logger.info("get all city by code");
        return cityCodesServices.findCityByCode(code);
    }


    /**
     *
     * @param name get all city by name
     * @return  all city by name
     */
    @GetMapping("by/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CityCodes> findCityByName(@PathVariable String name){
        logger.info("get all city by name ");
        return cityCodesServices.findCityCodeByName(name);
    }

}

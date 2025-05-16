package com.in.Controllers;

import com.in.model.Airports;
import com.in.services.AirportsServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/")
public class AirportsController {
    @Autowired
    private AirportsServices airportsServices;

    private static final Logger log= LoggerFactory.getLogger(AirportsController.class);

    /**
     *
     * @param code for find Airports
     * @return  All Airports by Code
     */
    @GetMapping("{code}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airports> findAirportByCode(@PathVariable String code){
        log.info("get all Airports by code");
        return airportsServices.findAirportsByCode(code);

    }

    /**
     *
     * @return all Airports
     */

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<Airports> findAllAirports(){
        log.info("get all Airports");
        return airportsServices.findAllAirports();
    }

    /**
     *
     * @param name
     * @return Airports by Name
     */

    @GetMapping("by/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airports> findAirportsByName(@PathVariable String name){
        log.info("get all airports by name");
        return airportsServices.findAirportsByName(name);
    }

}

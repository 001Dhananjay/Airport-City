package com.in.Controllers;

import com.in.model.Airports;
import com.in.services.AirportsServices;
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
    @GetMapping("{code}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airports> findAirportByCode(@PathVariable String code){
        System.out.println("controller");
        return airportsServices.findAirportsByCode(code);

    }
    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<Airports> findAllAirports(){
        return airportsServices.findAllAirports();
    }
    @GetMapping("by/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airports> findAirportsByName(@PathVariable String name){
        return airportsServices.findAirportsByName(name);
    }

}

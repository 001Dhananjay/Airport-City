package com.in.services;

import com.in.model.Airports;
import com.in.model.CityCodes;
import com.in.repo.CityCodesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CityCodesServicesTest {

    @InjectMocks
    private CityCodesServices cityCodesServices;
    @Mock
    private CityCodesRepository cityCodesRepository;


    @Test
    public void allCityCodeServiceTest(){
        CityCodes cityCodes1 = new CityCodes();
        cityCodes1.setCity("PAT");
        cityCodes1.setName("Patna");

        CityCodes cityCodes2=new CityCodes();
        cityCodes2.setName("Dharbhanga");
        cityCodes2.setCode("DBG");

        List<CityCodes> codesList=List.of(cityCodes1,cityCodes2);

        when(cityCodesRepository.findAll()).thenReturn(codesList);

        List<CityCodes> cityCodes=cityCodesServices.findAllCities();

        assertEquals(2,cityCodes.size());
        assertEquals("Patna", cityCodes.get(0).getName());
        assertEquals("Dharbhanga", cityCodes.get(1).getName());

        verify(cityCodesRepository).findAll();


    }

    @Test
    public void findCitysByName(){
        CityCodes cityCodes=new CityCodes();
        cityCodes.setCode("PAT");
        cityCodes.setName("Patna");

        when(cityCodesRepository.findByName("Patna")).thenReturn(Optional.of(cityCodes));

        Optional<CityCodes> result=cityCodesServices.findCityCodeByName("Patna");

        assertEquals("Patna",result.get().getName());
        assertEquals("PAT",result.get().getCode());


    }


    @Test
    public void find_City_by_Code(){

        CityCodes cityCodes=new CityCodes();
        cityCodes.setCode("BLR");
        cityCodes.setName("Bengaluru");

        // Mock the repository response
        when(cityCodesRepository.findById("BLR")).thenReturn(Optional.of(cityCodes));

        Optional<CityCodes> result = cityCodesServices.findCityByCode("BLR");

        assertEquals("Bengaluru", result.get().getName());
        assertEquals("BLR", result.get().getCode());

        // Optional: verify repository interaction
        verify(cityCodesRepository).findById("BLR");
    }



}

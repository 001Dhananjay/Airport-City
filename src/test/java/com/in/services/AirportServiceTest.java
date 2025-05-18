package com.in.services;

import com.in.model.Airports;
import com.in.repo.AirportsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {
    @Mock
    private AirportsRepository airportsRepository;

    @InjectMocks
    private AirportsServices airportService;




    @DisplayName("Find Airports by Name")
    @Test
    public void find_Airports_by_Code1(){
        Airports airport = new Airports();
        airport.setCode("AAA");
        airport.setName("Anaa");

        // Mock the repository response
        when(airportsRepository.findById("AAA")).thenReturn(Optional.of(airport));

        Optional<Airports> airports = airportService.findAirportsByCode("AAA");

        assertEquals("Anaa", airports.get().getName());

        // Optional: verify repository interaction
        verify(airportsRepository).findById("AAA");
    }


    @Test
    public void findALlAirportsTest(){
        // Prepare mock data
        Airports airport1 = new Airports();
        airport1.setCode("AAA");
        airport1.setName("Anaa");

        Airports airport2 = new Airports();
        airport2.setCode("BBB");
        airport2.setName("Bora Bora");

        List<Airports> airportList = List.of(airport1, airport2);

        // Mock the repository response
        when(airportsRepository.findAll()).thenReturn(airportList);

        // Call the service
        List<Airports> result = airportService.findAllAirports();

        // Assertions
        assertEquals(2, result.size());
        assertEquals("Anaa", result.get(0).getName());
        assertEquals("Bora Bora", result.get(1).getName());

        // Optional: verify interaction
        verify(airportsRepository).findAll();

    }

    @Test
    public void findAirportsByName(){
        Airports airports=new Airports();
        airports.setName("Adado Airport");
        airports.setCity("Adado");

        when(airportsRepository.findByName("Adado Airport")).thenReturn(Optional.of(airports));

        Optional<Airports> result=airportService.findAirportsByName("Adado Airport");

        assertEquals("Adado Airport",result.get().getName());
        assertEquals("Adado",result.get().getCity());


    }




}

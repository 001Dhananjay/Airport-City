package com.in.Controllers;

import com.in.model.Airports;
import com.in.services.AirportsServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(AirportsController.class)
public class AirportsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirportsServices airportsServices;

    @Test
    public void testFindAirportByCode() throws Exception {
        Airports airport = new Airports();
        airport.setCode("DEL");
        airport.setName("Delhi");

        when(airportsServices.findAirportsByCode("DEL")).thenReturn(Optional.of(airport));

        mockMvc.perform(get("/api/DEL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("DEL"))
                .andExpect(jsonPath("$.name").value("Delhi"));
    }


    @Test
    public void testFindAllAirports() throws Exception {
        Airports airport1 = new Airports();
        airport1.setCode("DEL");
        airport1.setName("Delhi");

        Airports airport2 = new Airports();
        airport2.setCode("BOM");
        airport2.setName("Mumbai");

        when(airportsServices.findAllAirports()).thenReturn(List.of(airport1, airport2));

        mockMvc.perform(get("/api/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Delhi"))
                .andExpect(jsonPath("$[1].code").value("BOM"));
    }

    @Test
    public void testFindAirportByName() throws Exception {
        Airports airport = new Airports();
        airport.setCode("BLR");
        airport.setName("Bangalore");

        when(airportsServices.findAirportsByName("Bangalore")).thenReturn(Optional.of(airport));

        mockMvc.perform(get("/api/by/Bangalore"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("BLR"))
                .andExpect(jsonPath("$.name").value("Bangalore"));
    }



}

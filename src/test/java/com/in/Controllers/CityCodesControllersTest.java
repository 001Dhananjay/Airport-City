package com.in.Controllers;

import com.in.model.CityCodes;
import com.in.services.CityCodesServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CityCodesControllers.class)
public class CityCodesControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityCodesServices cityCodesServices;

    @Test
    public void testFindAllCityCodes() throws Exception {
        CityCodes c1 = new CityCodes();
        c1.setCode("PAT");
        c1.setName("Patna");

        CityCodes c2 = new CityCodes();
        c2.setCode("DBG");
        c2.setName("Darbhanga");

        when(cityCodesServices.findAllCities()).thenReturn(List.of(c1, c2));

        mockMvc.perform(get("/city/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].code").value("PAT"))
                .andExpect(jsonPath("$[1].name").value("Darbhanga"));
    }

    @Test
    public void testFindCityByCode() throws Exception {
        CityCodes city = new CityCodes();
        city.setCode("BLR");
        city.setName("Bangalore");

        when(cityCodesServices.findCityByCode("BLR")).thenReturn(Optional.of(city));

        mockMvc.perform(get("/city/BLR"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("BLR"))
                .andExpect(jsonPath("$.name").value("Bangalore"));
    }

    @Test
    public void testFindCityByName() throws Exception {
        CityCodes city = new CityCodes();
        city.setCode("DEL");
        city.setName("Delhi");

        when(cityCodesServices.findCityCodeByName("Delhi")).thenReturn(Optional.of(city));

        mockMvc.perform(get("/city/by/Delhi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("DEL"))
                .andExpect(jsonPath("$.name").value("Delhi"));
    }
}

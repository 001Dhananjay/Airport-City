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
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(AirportsController.class)
public class AirportsController {
    @Autowired
    private MockMvc mockMvc;

    //@MockBean
    @MockitoBean
    private AirportsServices airportsServices;


    @Test
    void testFindAirportByCode() throws Exception {

    }


}

package com.in.services;

import com.in.model.Airports;
import com.in.repo.AirportsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {
    @Mock
    private AirportsRepository airportsRepository;

    @InjectMocks
    private AirportsServices airportService;
/*

    @Test
    void testGetAirportByCode_Found() {
        Airports airport = new Airports();
        airport.setCode("DEL");
        when(airportsRepository.findById("DEL")).thenReturn(Optional.of(airport));

        Optional<Airports> result = airportService.findAirportsByCode("DEL");

        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Delhi Airport");
        verify(airportsRepository).findById("DEL");
    }
*/

}

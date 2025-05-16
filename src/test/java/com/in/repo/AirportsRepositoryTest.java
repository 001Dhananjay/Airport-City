package com.in.repo;

import com.in.model.Airports;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

@SpringBootTest
public class AirportsRepositoryTest {
    @Autowired
    private AirportsRepository airportsRepository;

    @Test
    void testFindByCode(){
        Optional<Airports> result=airportsRepository.findById("AAA");
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Anaa");
    }

    @Test
    void testFindByInvalidCode() {
        Optional<Airports> result = airportsRepository.findByName("XYZ");
        assertThat(result).isNotPresent();
    }


}

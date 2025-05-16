package com.in.repo;

import com.in.model.CityCodes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

@SpringBootTest
public class CityCodesRepositoryTest {
    @Autowired
    private CityCodesRepository cityCodesRepository;
    @Test
    public void testFindByCode(){
        Optional<CityCodes> result=cityCodesRepository.findById("BAK");
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Baku Metropolitan Area");
    }

    @Test
    public void testFindByName(){
        Optional<CityCodes> result=cityCodesRepository.findByName("Beijing Metropolitan Area");
        assertThat(result).isPresent();
        assertThat(result.get().getCode()).isEqualTo("BJS");
    }

}

package com.in.repo;

import com.in.model.Airports;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportsRepository extends JpaRepository<Airports,String> {

    Optional<Airports> findById(String s);
    Optional<Airports> findByName(String name);
}

package com.in.repo;

import com.in.model.CityCodes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityCodesRepository extends JpaRepository<CityCodes,String> {
    Optional<CityCodes> findById(String s);
    Optional<CityCodes> findByName(String name);
}

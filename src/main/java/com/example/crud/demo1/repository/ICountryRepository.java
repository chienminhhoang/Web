package com.example.crud.demo1.repository;

import com.example.crud.demo1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country, Long> {
}

package com.example.crud.demo1.service.impl;

import com.example.crud.demo1.model.Country;
import com.example.crud.demo1.repository.ICountryRepository;
import com.example.crud.demo1.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CountryService implements ICountryService {
    @Autowired
    ICountryRepository iCountryRepository;
    @Override
    public Country save(Country country) {
        return iCountryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
         iCountryRepository.deleteById(id);

    }

    @Override
    public Optional<Country> findById(Long id) {
        return iCountryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return iCountryRepository.findAll();
    }
}

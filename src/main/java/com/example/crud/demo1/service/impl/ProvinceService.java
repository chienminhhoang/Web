package com.example.crud.demo1.service.impl;

import com.example.crud.demo1.model.Province;
import com.example.crud.demo1.repository.IProvinceRepository;
import com.example.crud.demo1.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProvinceService implements IProvinceService {
    @Autowired
    IProvinceRepository iProvinceRepository;

    @Override
    public Province save(Province province) {
        return iProvinceRepository.save(province);
    }

    @Override
    public void delete(Long id) {
        iProvinceRepository.deleteById(id);


    }

    @Override
    public Optional<Province> findById(Long id) {
        return iProvinceRepository.findById(id);
    }

    @Override
    public List<Province> findAll() {
        return iProvinceRepository.findAll() ;
    }

    @Override
    public List<Province> findBySearch(String name) {
        return null;
    }

//    @Override
//    public List<Province> findBySearch(String name) {
//        return iProvinceRepository.findByName("%"+name+"%");
//    }
}

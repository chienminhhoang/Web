package com.example.crud.demo1.service;

import com.example.crud.demo1.common.ICRUDService;
import com.example.crud.demo1.model.Province;

import java.util.List;

public interface IProvinceService extends ICRUDService<Province> {
    List<Province> findBySearch(String name);
}

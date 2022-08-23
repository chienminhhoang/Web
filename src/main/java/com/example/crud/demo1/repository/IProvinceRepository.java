package com.example.crud.demo1.repository;

import com.example.crud.demo1.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProvinceRepository extends JpaRepository<Province,Long> {
//    List<Province> findBySearch(String name);
//    @Query(value = "select * from student where name like :name", nativeQuery = true)
//    List<Province> findByName(@Param("name") String name);
}

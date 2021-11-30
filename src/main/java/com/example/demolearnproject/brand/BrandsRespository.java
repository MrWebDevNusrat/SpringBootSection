package com.example.demolearnproject.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandsRespository extends JpaRepository<Brand,Integer> {
    Long countById(Integer id);

    List<Brand> findAllByDeletedIsFalse();

    List<Brand> findAllByDeletedIsTrue();

}

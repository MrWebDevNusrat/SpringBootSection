package com.example.demolearnproject.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRespository extends JpaRepository<Category,Integer> {
    Long countById(Integer id);

    List<Category> findAllByDeletedIsFalse();
}

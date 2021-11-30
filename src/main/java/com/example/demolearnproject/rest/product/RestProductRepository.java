package com.example.demolearnproject.rest.product;

import com.example.demolearnproject.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAllByDeletedIsFalse();


    Integer countById(Integer id);
}

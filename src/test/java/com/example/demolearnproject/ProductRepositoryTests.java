package com.example.demolearnproject;

import com.example.demolearnproject.category.Category;
import com.example.demolearnproject.category.CategoryRespository;
import com.example.demolearnproject.product.Product;
import com.example.demolearnproject.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {

    @Autowired private ProductRepository productRepository;

    @Autowired private CategoryRespository categoryRespository;

}

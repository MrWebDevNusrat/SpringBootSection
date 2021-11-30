package com.example.demolearnproject;

import com.example.demolearnproject.brand.Brand;
import com.example.demolearnproject.brand.BrandsRespository;
import com.example.demolearnproject.category.Category;
import com.example.demolearnproject.category.CategoryRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BrandTests {

    @Autowired private CategoryRespository categoryRespository;
    @Autowired private BrandsRespository brandsRespository;

    @Test
    public void createNewBrandsTest(){
        Category categories = categoryRespository.findById(1).get();
        Brand brand = new Brand("Adidas", (List<Category>) categories);

        brandsRespository.save(brand);

    }
}

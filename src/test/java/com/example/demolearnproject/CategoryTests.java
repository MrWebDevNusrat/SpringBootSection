package com.example.demolearnproject;

import com.example.demolearnproject.category.Category;
import com.example.demolearnproject.category.CategoryRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryTests {

    @Autowired private CategoryRespository categoryRespository;

    @Test
    public void createNewCategoryTest(){

        categoryRespository.save(new Category("Oil industry"));

    }

}

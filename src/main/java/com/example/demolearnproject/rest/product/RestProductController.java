package com.example.demolearnproject.rest.product;

import com.example.demolearnproject.category.CategoryRespository;
import com.example.demolearnproject.category.CategoryService;
import com.example.demolearnproject.product.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class RestProductController {

    private final RestProductRepository productRepository;
    private final CategoryRespository categoryRespository;

    private final RestProductService productService;
    private final CategoryService categoryService;

    private final ProductDetailsRepository productDetailsRepository;

    private final FileDetailsRepository fileDetailsRepository;

    public RestProductController(RestProductRepository productRepository, CategoryRespository categoryRespository, RestProductService productService, CategoryService categoryService,ProductDetailsRepository productDetailsRepository,FileDetailsRepository fileDetailsRepository) {
        this.productRepository = productRepository;
        this.categoryRespository = categoryRespository;
        this.productService = productService;
        this.categoryService = categoryService;
        this.productDetailsRepository = productDetailsRepository;
        this.fileDetailsRepository = fileDetailsRepository;
    }

    @GetMapping("/product")
    public List<Product> listProductOne(){
        List<Product> productList = productService.listIsFalse();
        return productList;
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> findUserById(@PathVariable(value = "id") Integer id) {
        Optional<Product> user = productRepository.findById(id);

        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Product product, @PathVariable Integer id) throws ProductNotFoundException {

        Product student = productService.get(id);
        productService.save(student);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/productDetails")
    public List<ProductDetails> listProduct(){
        List<ProductDetails> productDetails = productDetailsRepository.findAll();
        return productDetails;
    }

    @GetMapping("/fileDetails")
    public List<FileDetails> getListFileDetails(){
        List<FileDetails> fileDetails = fileDetailsRepository.findAll();
        return fileDetails;
    }



}

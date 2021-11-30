package com.example.demolearnproject.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired private ProductRepository repo;

    public List<Product> listAll(){
        return (List<Product>) repo.findAll();
    }

    public List<Product> listIsFalse(){
        return (List<Product>) repo.findAllByDeletedIsFalse();
    }

    public Product save(Product product){
        repo.save(product);
        return product;
    }

    public Product get(Integer id) throws ProductNotFoundException{
        Optional<Product> result = repo.findById(id);

        if (result.isPresent()){
            return result.get();
        }

        throw new ProductNotFoundException("Could not find any products with ID: "  + id);
    }

    public void remove(Integer id) throws ProductNotFoundException{

        Integer count = repo.countById(id);

        if (count == null || count == 0){
            throw new ProductNotFoundException("Could not find any produdts with ID: " + id);
        }

        repo.deleteById(id);
    }

}

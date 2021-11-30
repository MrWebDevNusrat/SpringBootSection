package com.example.demolearnproject.product;

public class ProductNotFoundException extends Throwable{

    public ProductNotFoundException(String message) {
        super(message);
    }
}

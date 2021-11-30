package com.example.demolearnproject.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.File;

@Entity
public class FileDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 120,nullable = false)
    private String file;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "file_extension")
    private String fileExtension;


    public FileDetails(){

    }

    public FileDetails(Integer id, String file, Product product) {
        this.id = id;
        this.file = file;
        this.product = product;
    }

    public FileDetails(String file,String FileExtension, Product product) {
        this.id = id;
        this.file = file;
        this.fileExtension = FileExtension;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public String toString() {
        return "FileDetails{" +
                "file='" + file + '\'' +
                '}';
    }
}

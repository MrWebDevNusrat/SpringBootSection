package com.example.demolearnproject.product;

import com.example.demolearnproject.category.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id =?")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 120,nullable = false,unique = true)
    private String name;

    private float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
//    @JsonBackReference
    private Category category;

    @Column(length = 120,nullable = true)
    private String image;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    //    @JsonBackReference
    private List<ProductDetails> details = new ArrayList<>();

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//    @JsonBackReference
    private List<FileDetails> fileDetails = new ArrayList<>();

    private boolean deleted = Boolean.FALSE;

    public Product(String name, float price,Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(Integer id){
        this.id = id;
    }

    public Product(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductDetails> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetails> details) {
        this.details = details;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<FileDetails> getFileDetails() {
        return fileDetails;
    }

    public void setFileDetails(List<FileDetails> fileDetails) {
        this.fileDetails = fileDetails;
    }

    public void setFdetail(Integer id,String file){
        this.fileDetails.add(new FileDetails(id,file,this));
    }

    public void addFdetail(String file,String image){
        this.fileDetails.add(new FileDetails(file,image,this));
    }

    public void setDetail(Integer id, String name, String value){
        this.details.add(new ProductDetails(id,name,value,this));
    }

    public void addDetail(String name,String value){
        this.details.add(new ProductDetails(name,value,this));
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    @Transient
    public String getImagePath(){
        if (image == null || id == null) return null;

        return "/product-images/" + id + "/" + image;
    }

}

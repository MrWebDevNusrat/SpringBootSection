package com.example.demolearnproject.brand;

import com.example.demolearnproject.category.Category;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
@SQLDelete(sql = "UPDATE brand SET deleted = true WHERE id=?")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150,nullable = false,unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name = "brand_id")
    private List<Category> categories = new ArrayList<>();

    @Column(length = 45,nullable = true)
    private String logo;

    @Column
    private boolean deleted = Boolean.FALSE;

    public Brand(){

    }

    public Brand(String name) {
        this.name = name;
    }

    public Brand(String name, List<Category> categories) {
        this.name = name;
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Transient
    public String getLogoImagePath(){
        if (logo == null || id == null) return null;

        return "/brand-logos/" + id + "/" + logo;
    }
}

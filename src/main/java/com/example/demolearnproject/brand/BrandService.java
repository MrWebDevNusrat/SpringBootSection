package com.example.demolearnproject.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired private BrandsRespository repo;

    public List<Brand> findAll(){
        return  (List<Brand>) repo.findAll();
    }

    public List<Brand> findAllByDeletedIsNull() {
        return (List<Brand>) repo.findAllByDeletedIsFalse();
    }

    public Brand save(Brand brand){
        repo.save(brand);
        return brand;
    }

    public Brand get(Integer id) throws BrandNotFoundException{
        Optional<Brand> result = repo.findById(id);

        if (result.isPresent()){
            return result.get();
        }

        throw new BrandNotFoundException("Could not find any users with ID: " + id);
    }

    public void remove(Integer id) throws BrandNotFoundException{
        Long count = repo.countById(id);

        if (count == null || count == 0){
            throw new BrandNotFoundException("The brand's ID: " + id + "has been deleted");
        }

        repo.deleteById(id);
    }


    /*public void delete(Integer id) throws BrandNotFoundException{
        Long count = repo.countById(id);

        if (count == null || count == 0){
            throw new BrandNotFoundException("Could not find any brands with ID: " + id);
        }

        repo.deleteById(id);
    }*/

}

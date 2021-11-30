package com.example.demolearnproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired private RoleRepository repo;

    public List<Role> listAll(){
        return (List<Role>) repo.findAll();
    }

    public void save(Role role){
        repo.save(role);
    }

    public Role get(Integer id) throws RoleNotFoundException{
        Optional<Role> result = repo.findById(id);

        if (result.isPresent()){
            return result.get();
        }

        throw new RoleNotFoundException("Could not find any users with ID: " + id);

    }

    public void delete(Integer id) throws RoleNotFoundException{
        Long count = repo.countById(id);

        if (count == null || count == 0){
            throw new RoleNotFoundException("Could not find any roles with ID: " + id);
        }

        repo.deleteById(id);

    }

}

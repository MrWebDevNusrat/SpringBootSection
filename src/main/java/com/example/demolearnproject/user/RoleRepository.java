package com.example.demolearnproject.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Long countById(Integer id);

    Role findByName(String role_admin);
}

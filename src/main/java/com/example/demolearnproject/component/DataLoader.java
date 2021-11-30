package com.example.demolearnproject.component;

import com.example.demolearnproject.user.Role;
import com.example.demolearnproject.user.RoleRepository;
import com.example.demolearnproject.user.User;
import com.example.demolearnproject.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader  implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    private String mode="never";


    @Override
    public void run(String... args) throws Exception {

        if (mode.equals("always")) {
            User user = new User();
            user.setEmail("a@mail.ru");
            user.setUsername("shamsiddin");
            user.setPassword(passwordEncoder.encode("shamsiddin"));
            user.setRoles((Set<Role>) roleRepository.findByName("ROLE_ADMIN"));
            user.setRole("ROLE_ADMIN");
            userRepository.save(user);


        }

    }
}

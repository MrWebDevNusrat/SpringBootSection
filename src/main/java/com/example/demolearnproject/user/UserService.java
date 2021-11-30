package com.example.demolearnproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public List<User> listIsFalse(){
        return repo.findAllByDeletedIsFalse();
    }

    public void save(User user){
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException{
        Optional<User> result = repo.findById(id);

        if (result.isPresent()){
            return result.get();
        }

        throw new UserNotFoundException("Could not find any users with ID: " + id);

    }

    public void delete(Integer id) throws UserNotFoundException{

        Long count = repo.countById(id);

        if (count == null || count == 0){
            throw new UserNotFoundException("Could not find any users with ID: " + id);
        }

        repo.deleteById(id);
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=repo.findByUsername(s);
        if (user == null) throw new UsernameNotFoundException(s);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
//        return new User(String.valueOf(user.getUsername(), user.getPassword(), getAuthority(user));
    }
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority("ROLE_"+role.getName())).collect(Collectors.toSet());
        return authorities;
    }
}

package com.cinema.cinemaparadiso.service;

import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.repository.AuthoritiesRepository;
import com.cinema.cinemaparadiso.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public Iterable<User> list(){
        return userRepository.findAll();
    }

    public void createUser(User user){
        String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
        user.setPassword(encryptedPassword);
        user.setEnabled(true);
        userRepository.save(user);
        Authorities authorities = new Authorities(user.getUsername(),"admin");
        authoritiesRepository.save(authorities);
    }
}

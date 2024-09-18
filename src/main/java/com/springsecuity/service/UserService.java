package com.springsecuity.service;

import com.springsecuity.Repository.UserRepository;
import com.springsecuity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();

    public  Users saveUser( Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

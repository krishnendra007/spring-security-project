package com.springsecuity.config;

import com.springsecuity.Repository.UserRepository;
import com.springsecuity.model.UserPrincipal;
import com.springsecuity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);

        if(user==null){
            System.out.println("Unser not found");
            throw  new UsernameNotFoundException("USer not found");
        }

        return new UserPrincipal(user);
    }
}

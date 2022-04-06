package com.jwt.auth.jwt.security.config;

import com.jwt.auth.jwt.security.dao.UserRepository;
import com.jwt.auth.jwt.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user=userRepository.getUserByUserName(username);
//        if(user==null)
//            throw new UsernameNotFoundException("Incorrect username or password");
        return new org.springframework.security.core.userdetails.User("Shiv","Shiv@", List.of());
    }
}

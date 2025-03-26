package com.dmslmvsk.spring_jwt.service;

import com.dmslmvsk.spring_jwt.entity.User;
import com.dmslmvsk.spring_jwt.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByUsername(String username){
        User user = userRepository.findByUsername(username).orElse(null);
        if (user!=null){
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public boolean existsByEmail(String email){
        User user = userRepository.findByEmail(email).orElse(null);
        if(user!=null){
            return true;
        }
        return false;
    }

}

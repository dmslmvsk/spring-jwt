package com.dmslmvsk.spring_jwt.service;

import com.dmslmvsk.spring_jwt.dto.UserDto;
import com.dmslmvsk.spring_jwt.entity.User;
import com.dmslmvsk.spring_jwt.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByUsername(String username){
        User user = userRepository.findByUsername(username).orElse(null);
        return user != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public boolean existsByEmail(String email){
        User user = userRepository.findByEmail(email).orElse(null);
        return user != null;
    }

    public UserDto findUserByUsername(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow();
        return new UserDto(user.getUsername(),user.getEmail(),user.getId());
    }

}

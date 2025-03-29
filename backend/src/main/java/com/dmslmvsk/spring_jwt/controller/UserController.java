package com.dmslmvsk.spring_jwt.controller;

import com.dmslmvsk.spring_jwt.dto.UserDto;
import com.dmslmvsk.spring_jwt.entity.User;
import com.dmslmvsk.spring_jwt.service.UserService;
import com.dmslmvsk.spring_jwt.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserByUsername(){
        return ResponseEntity.ok(userService.findUserByUsername());
    }
}

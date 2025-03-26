package com.dmslmvsk.spring_jwt.controller;

import com.dmslmvsk.spring_jwt.dto.AuthenticationResponseDto;
import com.dmslmvsk.spring_jwt.dto.LoginRequestDto;
import com.dmslmvsk.spring_jwt.dto.RegistrationRequestDto;
import com.dmslmvsk.spring_jwt.service.AuthenticationService;
import com.dmslmvsk.spring_jwt.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService){
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> register(
            @RequestBody RegistrationRequestDto registrationDto) {
        if(userService.existsByUsername(registrationDto.getUsername())){
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        if(userService.existsByEmail(registrationDto.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already taken");
        }

        authenticationService.register(registrationDto);

        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> authenticate(
            @RequestBody LoginRequestDto request) {

        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh_token")
    public ResponseEntity<AuthenticationResponseDto> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        return authenticationService.refreshToken(request,response);
    }
}

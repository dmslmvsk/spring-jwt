package com.dmslmvsk.spring_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        System.out.println("hello");
        return ResponseEntity.ok("Hello user");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> helloA() {
        return ResponseEntity.ok("Hello admin");
    }

    @GetMapping("/")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello world");
    }
}

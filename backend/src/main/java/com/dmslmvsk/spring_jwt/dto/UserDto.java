package com.dmslmvsk.spring_jwt.dto;


import lombok.Getter;

@Getter
public class UserDto {
    private final String username;

    private final String email;

    private final Long id;

    public UserDto(String username, String email, Long id){
        this.email = email;
        this.username = username;
        this.id = id;
    }
}

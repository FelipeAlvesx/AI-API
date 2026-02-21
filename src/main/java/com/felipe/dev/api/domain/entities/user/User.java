package com.felipe.dev.api.domain.entities.user;

import com.felipe.dev.api.domain.UserType;
import com.felipe.dev.api.infra.controller.DTOS.UserDto;

import java.util.UUID;

public class User {

    private Long id;
    private String name;
    private String email;

    private String phone;

    private UserType userType;

    public User(Long id ,String name, String email, UserType userType, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.phone = phone;
    }

    public User(){

    }

    public User(UserDto userDto) {
        this.name = userDto.name();
        this.email = userDto.email();
        this.phone = userDto.phone();
        this.userType = UserType.valueOf(userDto.userType());
    }


    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}

package com.felipe.dev.api.domain.entities;

import com.felipe.dev.api.domain.UserType;

public class User {

    private String name;
    private String email;

    private UserType userType;

    public User(String name, String email, UserType userType) {
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public User(){

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

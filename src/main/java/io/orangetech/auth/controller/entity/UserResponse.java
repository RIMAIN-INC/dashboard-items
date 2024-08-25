package io.orangetech.auth.controller.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserResponse {
    private String  email;
    private  String password;
    private String username;

    public UserResponse(String email, String password, String username){
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public UserResponse(){};

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

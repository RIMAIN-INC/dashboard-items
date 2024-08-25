package io.orangetech.auth.controller.entity;

public class LoginResponse {
    private String email;
    private String password;

    public LoginResponse(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginResponse (){};

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

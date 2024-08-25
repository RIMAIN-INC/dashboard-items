package io.orangetech.auth.controller.entity;

import jakarta.persistence.*;

@Entity
@Table(name="accounts")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String username;
    private String  email;
    private  String password;
    @Enumerated(EnumType.STRING)
    private Roles role;

    public User(String username, String email, String password, Roles role){
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(){};

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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

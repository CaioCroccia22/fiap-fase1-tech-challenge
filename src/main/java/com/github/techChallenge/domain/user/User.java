package com.github.techChallenge.domain.user;

import java.time.LocalDateTime;

public class User {

    private Long id;
    private String name;
    private String email;
    private String login;
    private String password;
    private UserLevel level;
    private Address address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(
            Long id,
            String name,
            String email,
            String login,
            String password,
            UserLevel level,
            Address address,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.level = level;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static User create(
            String name,
            String email,
            String login,
            String password,
            UserLevel level,
            Address address
    ) {
        LocalDateTime now = LocalDateTime.now();

        return new User(
                null,
                name,
                email,
                login,
                password,
                level,
                address,
                now,
                now
        );
    }

    public void update(
            String name,
            String email,
            String login,
            UserLevel level,
            Address address
    ) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.level = level;
        this.address = address;
        this.updatedAt = LocalDateTime.now();
    }

    public void changePassword(String password) {
        this.password = password;
        this.updatedAt = LocalDateTime.now();
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserLevel getLevel() {
        return level;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
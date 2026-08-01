package com.github.techChallenge.domain.user;

import com.github.techChallenge.domain.user.dto.UserCreateInputDTO;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String name;
    private String login;
    private String password;
    private UserLevel level;
    private Address address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(Long id, String name, String login, String password, UserLevel level, Address address,
                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.level = level;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(UserCreateInputDTO dto) {
        this.name = dto.name();
        this.login = dto.login();
        this.level = dto.level();
        this.address = dto.address();
    }

    public void create() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

package com.github.techChallenge.domain.user;

import com.github.techChallenge.domain.usertype.UserType;

import java.time.LocalDateTime;
import java.util.Locale;

public class User {

    private Long id;
    private String name;
    private String email;
    private String login;
    private String password;
    private UserLevel userLevel;
    private UserType type;
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
            UserLevel userLevel,
            UserType type,
            Address address,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.userLevel = userLevel;
        this.type = type;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static User create(
            String name,
            String email,
            String login,
            String password,
            UserLevel userLevel,
            Address address
    ) {
        LocalDateTime now = LocalDateTime.now();
        email = email
                .trim()
                .toLowerCase(Locale.ROOT);

        login = login
                .trim()
                .toLowerCase(Locale.ROOT);

        return new User(
                null,
                name,
                email,
                login,
                password,
                userLevel,
                null,
                address,
                now,
                now
        );
    }

    public void update(
            String name,
            String email,
            String login,
            UserLevel userLevel,
            Address address
    ) {

        email = email
                .trim()
                .toLowerCase(Locale.ROOT);

        login = login
                .trim()
                .toLowerCase(Locale.ROOT);

        this.name = name;
        this.email = email;
        this.login = login;
        this.address = address;
        this.userLevel = userLevel;
        this.updatedAt = LocalDateTime.now();
    }

    public void changePassword(String password) {
        this.password = password;
        this.updatedAt = LocalDateTime.now();
    }

    public void grantType(UserType userType) {
        this.type = userType;
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

    public UserType getType() {
        return type;
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

    public UserLevel getUserLevel() {return userLevel;}
}
package com.github.techChallenge.infrastructure.entities.user;

import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.UserLevel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name="usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String login;
    private String password;
    private UserLevel level;
    @Embedded
    private AddressEntity address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdated_at(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserEntity(){}

    public UserEntity(User user) {
        if (Optional.ofNullable(user.getId()).isPresent() && user.getId() > 0)
            this.setId(user.getId());

        if (Optional.ofNullable(user.getName()).isPresent()) this.setName(user.getName());
        if (Optional.ofNullable(user.getLogin()).isPresent()) this.setLogin(user.getLogin());
        if (Optional.ofNullable(user.getPassword()).isPresent()) this.setPassword(user.getPassword());
        if (Optional.ofNullable(user.getLevel()).isPresent()) this.setLevel(user.getLevel());
        if (Optional.ofNullable(user.getLogin()).isPresent()) this.setLogin(user.getLogin());
        if (Optional.ofNullable(user.getAddress()).isPresent()) this.setAddress(new AddressEntity(user.getAddress()));
        if (Optional.ofNullable(user.getLogin()).isPresent()) this.setLogin(user.getLogin());
        if (Optional.ofNullable(user.getCreatedAt()).isPresent()) this.setCreatedAt(user.getCreatedAt());
        if (Optional.ofNullable(user.getUpdatedAt()).isPresent()) this.setCreatedAt(user.getCreatedAt());
    }
}

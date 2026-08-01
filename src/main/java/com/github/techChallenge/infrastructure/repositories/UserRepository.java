package com.github.techChallenge.infrastructure.repositories;

import com.github.techChallenge.infrastructure.entities.user.UserEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Page<UserEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

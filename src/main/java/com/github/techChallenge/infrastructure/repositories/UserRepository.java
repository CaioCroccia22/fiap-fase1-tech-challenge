package com.github.techChallenge.infrastructure.repositories;

import com.github.techChallenge.infrastructure.entities.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findByNameContainingIgnoreCase(
            String name,
            Pageable pageable
    );

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByLoginIgnoreCase(String login);

    @Query(value = "SELECT SENHA FROM usuarios WHERE LOGIN = :login", nativeQuery = true)
    String findPasswordByLogin(@Param("login") String login);

}
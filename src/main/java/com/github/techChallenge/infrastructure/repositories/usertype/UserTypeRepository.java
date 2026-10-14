package com.github.techChallenge.infrastructure.repositories.usertype;

import com.github.techChallenge.infrastructure.entities.usertype.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserTypeEntity, Integer> {

    boolean existsByTitleIgnoreCase(String title);
    boolean existsByTitleAndIdNot(String email, int id);

}
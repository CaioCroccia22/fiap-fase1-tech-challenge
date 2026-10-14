package com.github.techChallenge.application.repositories;

import com.github.techChallenge.domain.usertype.UserType;
import org.springframework.data.domain.Page;

public interface IUserTypeRepository {
    UserType create(UserType usertype);
    UserType update(UserType usertype, int id);
    UserType findByID(int id);
    Page<UserType> list(int page, int offset);
    void delete(int id);
    boolean existsByTitle(String title);
    boolean existsByTitleAndIdNot(String title, int id);
    boolean existsById(int id);
}
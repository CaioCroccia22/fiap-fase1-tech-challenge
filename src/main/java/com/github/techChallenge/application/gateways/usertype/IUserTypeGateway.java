package com.github.techChallenge.application.gateways.usertype;

import com.github.techChallenge.domain.usertype.UserType;
import org.springframework.data.domain.Page;

public interface IUserTypeGateway {
    UserType create(UserType userType);
    UserType update(UserType userType, int id);
    UserType find(int id);
    Page<UserType> list(Integer page, Integer offset);
    void delete(int id);
    boolean titleExists(String title, int id);
    boolean titleExists(String title);
    boolean existById(int id);
}

package com.github.techChallenge.application.gateways;

import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.UserCreateInputDTO;
import com.github.techChallenge.domain.user.dto.UserOutputDTO;
import com.github.techChallenge.domain.user.dto.UserUpdateInputDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserGateway {
    User create(UserCreateInputDTO dto);
    User update(UserUpdateInputDTO dto, Long id);
    User find(Long id);
    Page<User> listByName(String name, int page, int offset);
    Page<User> list(Integer page, Integer offset);
    void delete(Long id);
}

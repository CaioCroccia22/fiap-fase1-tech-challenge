package com.github.techChallenge.application.gateways;

import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.UserCreateInputDTO;
import com.github.techChallenge.domain.user.dto.UserOutputDTO;
import com.github.techChallenge.application.repositories.IUserRepository;
import com.github.techChallenge.domain.user.dto.UserUpdateInputDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public class UserGateway implements IUserGateway {
    private final IUserRepository repository;
    private final IUserMapper mapper;
    public UserGateway(IUserRepository repository, IUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User create(UserCreateInputDTO dto) {
        User user = new User(dto);
        user.create();
        user = this.repository.create(user);
        return user;
    }

    @Override
    public User update(UserUpdateInputDTO dto, Long id) {
        User user = this.repository.update(dto, id);
        return user;
    }

    @Override
    public Page<User> listByName(String name, int page, int offset) {
        Page<User> users = this.repository.listByName(name, page, offset);

        return users;
    }

    @Override
    public User find(Long id) {
        User user = this.repository.findByID(id);
        return user;
    }

    @Override
    public Page<User> list(Integer page, Integer offset) {
        Page<User> users = this.repository.list(page, offset);

        return users;
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }
}

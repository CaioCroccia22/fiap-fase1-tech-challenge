package com.github.techChallenge.application.gateways.usertype;

import com.github.techChallenge.application.repositories.IUserTypeRepository;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.domain.usertype.UserType;
import org.springframework.data.domain.Page;

public class UserTypeGateway implements IUserTypeGateway {

    private final IUserTypeRepository repository;
    private final IUserTypeMapper mapper;

    public UserTypeGateway(IUserTypeRepository repository, IUserTypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserType create(UserType user) {
        return repository.create(user);
    }

    @Override
    public UserType update(UserType user, int id) {
        user = this.repository.update(user, id);
        return user;
    }

    @Override
    public UserType find(int id) {
        UserType userType = this.repository.findByID(id);
        return userType;
    }

    @Override
    public Page<UserType> list(Integer page, Integer offset) {
        Page<UserType> users = this.repository.list(page, offset);

        return users;
    }

    @Override
    public void delete(int id) {
        this.repository.delete(id);
    }

    @Override
    public boolean titleExists(String title, int id) {
        return this.repository.existsByTitleAndIdNot(title, id);
    }

    @Override
    public boolean titleExists(String title) {
        return this.repository.existsByTitle(title);
    }

    @Override
    public boolean existById(int id) {
        return this.repository.existsById(id);
    }

}

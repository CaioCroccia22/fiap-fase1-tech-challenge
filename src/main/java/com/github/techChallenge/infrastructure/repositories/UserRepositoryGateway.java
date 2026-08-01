package com.github.techChallenge.infrastructure.repositories;

import com.github.techChallenge.application.repositories.IUserRepository;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.UserUpdateInputDTO;
import com.github.techChallenge.infrastructure.entities.user.AddressEntity;
import com.github.techChallenge.infrastructure.entities.user.UserEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class UserRepositoryGateway implements IUserRepository {

    @Autowired
    private UserRepository repository;

    @Autowired
    private IUserMapper mapper;

    @Override
    public User create(User user) {
        UserEntity userEntity = new UserEntity(user);
        userEntity = this.repository.save(userEntity);
        return this.mapper.fromEntityToDomain(userEntity);
    }

    @Override
    public User update(UserUpdateInputDTO dto, Long id) {
        Optional<UserEntity> entity = this.repository.findById(id);
        if (!entity.isPresent()) throw new EntityNotFoundException("Usuário não encontrado");
        AddressEntity addressEntity = new AddressEntity(dto.address());

        UserEntity userEntity = entity.get();
        userEntity.setName(dto.name());
        userEntity.setLogin(dto.login());
        userEntity.setLevel(dto.level());
        userEntity.setAddress(addressEntity);

        userEntity = this.repository.save(userEntity);
        return this.mapper.fromEntityToDomain(userEntity);
    }

    @Override
    public Page<User> listByName(String name, int page, int offset) {
        Pageable pageable = PageRequest.of(page, offset);
        Page<UserEntity> entitiesPage =  this.repository.findByNameContainingIgnoreCase(name, pageable);

        return this.mapper.fromEntityPageToDomainPage(entitiesPage);
    }

    @Override
    public User findByID(Long id) {
        Optional<UserEntity> entity = this.repository.findById(id);
        if (!entity.isPresent()) throw new EntityNotFoundException("Usuário não encontrado");

        return this.mapper.fromEntityToDomain(entity.get());
    }

    @Override
    public Page<User> list(int page, int offset) {
        Pageable pageable = PageRequest.of(page, offset);
        Page<UserEntity> entitiesPage =  this.repository.findAll(pageable);

        return this.mapper.fromEntityPageToDomainPage(entitiesPage);
    }

    @Override
    public void delete(Long id) {
        Optional<UserEntity> entity = this.repository.findById(id);
        if (!entity.isPresent()) throw new EntityNotFoundException("Usuário não encontrado");

        this.repository.delete(entity.get());
    }
}

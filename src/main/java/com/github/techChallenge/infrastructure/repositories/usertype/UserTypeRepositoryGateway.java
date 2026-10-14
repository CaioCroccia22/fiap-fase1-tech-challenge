package com.github.techChallenge.infrastructure.repositories.usertype;

import com.github.techChallenge.application.exceptions.UserTypeNotFoundException;
import com.github.techChallenge.application.repositories.IUserTypeRepository;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.infrastructure.entities.usertype.UserTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class UserTypeRepositoryGateway implements IUserTypeRepository {

    @Autowired
    private UserTypeRepository repository;
    @Autowired
    private IUserTypeMapper mapper;

    @Override
    public UserType create(UserType userType) {
        UserTypeEntity userTypeEntity = new UserTypeEntity(userType);
        userTypeEntity = this.repository.save(userTypeEntity);
        return this.mapper.fromEntityToDomain(userTypeEntity);
    }

    @Override
    public UserType update(UserType userType, int id) {

        Optional<UserTypeEntity> entity = this.repository.findById(id);
        if (!entity.isPresent()) throw new UserTypeNotFoundException("Nível de usuário não encontrado");

        UserTypeEntity userTypeEntity = entity.get();
        userTypeEntity.setTitle(userType.getTitle());

        userTypeEntity = this.repository.save(userTypeEntity);
        return this.mapper.fromEntityToDomain(userTypeEntity);
    }

    @Override
    public UserType findByID(int id) {
        Optional<UserTypeEntity> entity = this.repository.findById(id);
        if (!entity.isPresent()) throw new UserTypeNotFoundException("Nível de usuário não encontrado");

        return this.mapper.fromEntityToDomain(entity.get());
    }

    @Override
    public Page<UserType> list(int page, int offset) {
        Pageable pageable = PageRequest.of(page, offset);
        Page<UserTypeEntity> entitiesPage =  this.repository.findAll(pageable);

        return this.mapper.fromEntityPageToDomainPage(entitiesPage);
    }

    @Override
    public void delete(int id) {
        Optional<UserTypeEntity> entity = this.repository.findById(id);
        if (!entity.isPresent()) throw new UserTypeNotFoundException("Nível de usuário não encontrado");

        this.repository.delete(entity.get());
    }

    @Override
    public boolean existsByTitle(String title) {
        return repository.existsByTitleIgnoreCase(title);
    }

    @Override
    public boolean existsByTitleAndIdNot(String title, int id) {
        return this.repository.existsByTitleAndIdNot(title, id);
    }

    @Override
    public boolean existsById(int id) {
        return this.repository.existsById(id);
    }
}

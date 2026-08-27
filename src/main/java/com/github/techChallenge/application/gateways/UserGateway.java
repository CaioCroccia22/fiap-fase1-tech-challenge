package com.github.techChallenge.application.gateways;

import com.github.techChallenge.application.exceptions.InvalidPasswordException;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.UserCreateInputDTO;
import com.github.techChallenge.application.repositories.IUserRepository;
import com.github.techChallenge.domain.user.dto.UserUpdateInputDTO;
import com.github.techChallenge.infrastructure.security.ISecurityConfig;
import com.github.techChallenge.infrastructure.security.SecurityConfig;
import com.github.techChallenge.shared.UnauthorizedException;
import com.github.techChallenge.shared.UserNotFoundException;
import org.springframework.data.domain.Page;

import com.github.techChallenge.shared.EmailAlreadyExistsException;
import com.github.techChallenge.shared.LoginAlreadyExistsException;

import java.util.Locale;

public class UserGateway implements IUserGateway {

    private final IUserRepository repository;
    private final ISecurityConfig securityConfig;
    private final IUserMapper mapper;

    public UserGateway(IUserRepository repository, IUserMapper mapper,ISecurityConfig securityConfig) {
        this.repository = repository;
        this.securityConfig = securityConfig;
        this.mapper = mapper;
    }

    @Override
    public User create(User user) {
        return repository.create(user);
    }

    @Override
    public User update(User user, Long id) {
        user = this.repository.update(user, id);
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

    @Override
    public boolean validate(String rawPassword, String login){

        if (!repository.existsByLogin(login)) {throw new UnauthorizedException() {
        };}

        String encryptPasswordDataBase = this.repository.getEncryptPasswordByLogin(login);

        if(encryptPasswordDataBase.isEmpty()){throw new InvalidPasswordException("Senha inválida e/ou vazia");};

        if(securityConfig.passwordValidate(rawPassword, encryptPasswordDataBase)
                && repository.existsByLogin(login)){
            return true;
        } else {
            throw new UnauthorizedException();
        }
    }

    public boolean changePassword(String rawPassword, String login){
        if (!repository.existsByLogin(login)) {throw new UnauthorizedException() {
        };}
        return repository.updatePasswordByLogin(securityConfig.passwordEncoder(rawPassword), login);
    }

    @Override
    public boolean emailExists(String email, Long id) {
        return this.repository.existsByEmailAndIdNot(email, id);
    }

    @Override
    public boolean loginExists(String login) {
        return this.repository.existsByLogin(login);
    }

    @Override
    public boolean loginExists(String login, Long id) {
        return this.repository.existsByLoginAndIdNot(login, id);
    }

    @Override
    public boolean existById(Long id) {
        return this.repository.existsById(id);
    }

    public boolean emailExists(String email) {
        return this.repository.existsByEmail(email);
    }
}

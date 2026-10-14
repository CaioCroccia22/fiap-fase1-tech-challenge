package com.github.techChallenge.application.gateways.user;

import com.github.techChallenge.application.repositories.IUserTypeRepository;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.application.repositories.IUserRepository;
import com.github.techChallenge.domain.user.dto.GrantUserTypeInputDTO;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.infrastructure.security.ISecurityConfig;
import org.springframework.data.domain.Page;

public class UserGateway implements IUserGateway {

    private final IUserRepository repository;
    private final ISecurityConfig securityConfig;
    private final IUserMapper mapper;
    private final IUserTypeRepository userTypeRepository;

    public UserGateway(IUserRepository repository, IUserMapper mapper,ISecurityConfig securityConfig,
                       IUserTypeRepository userTypeRepository) {
        this.repository = repository;
        this.securityConfig = securityConfig;
        this.mapper = mapper;
        this.userTypeRepository = userTypeRepository;
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
    public String getEncryptPasswordByLogin(String login){

        return this.repository.getEncryptPasswordByLogin(login);

    }

    public boolean changePassword(String encodedPassword, String Login){
        return repository.updatePasswordByLogin(encodedPassword, Login);
    }

    @Override
    public User grantUserType(GrantUserTypeInputDTO dto) {
        User user = this.repository.findByID(dto.userID());
        UserType userType = this.userTypeRepository.findByID(dto.userTypeID());

        user.grantType(userType);
        user = this.repository.update(user, dto.userID());
        return user;
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

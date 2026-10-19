package com.github.techChallenge.application.usecases.user;

import com.github.techChallenge.application.gateways.user.IUserGateway;
import com.github.techChallenge.application.validators.UserValidator;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.UserCreateInputDTO;
import com.github.techChallenge.domain.user.dto.UserOutputDTO;
import com.github.techChallenge.infrastructure.security.ISecurityConfig;
import com.github.techChallenge.shared.EmailAlreadyExistsException;
import com.github.techChallenge.shared.LoginAlreadyExistsException;

public class CreateUserUseCase extends UserUseCase {

    private final ISecurityConfig securityConfig;

    private final UserValidator validator;

    public CreateUserUseCase(IUserGateway gateway, IUserMapper mapper, ISecurityConfig securityConfig, UserValidator validator) {
        super(gateway, mapper);
        this.securityConfig = securityConfig;
        this.validator = validator;
    }

    public UserOutputDTO execute(UserCreateInputDTO dto) {
        User user = User.create(
                dto.name(),
                dto.email(),
                dto.login(),
                dto.password(),
                dto.userLevel(),
                dto.address());

        if (validator.emailExists(user.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        if (validator.loginExists(user.getLogin())) {
            throw new LoginAlreadyExistsException();
        }

        user.encodePassword(rawPassword ->
                securityConfig.passwordEncoder(rawPassword, user.getLogin()));

        User savedUser = this.gateway.create(user);
        return this.mapper.fromDomainToOutputDTO(savedUser);
    }
}

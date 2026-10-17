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

        if (validator.emailExists(dto.email()))
            throw new EmailAlreadyExistsException();

        if (validator.loginExists(dto.login()))
            throw new LoginAlreadyExistsException();

        User user = User.create(
                dto.name(),
                dto.email(),
                dto.login(),
                securityConfig.passwordEncoder(dto.password(), dto.login()),
                dto.userLevel(),
                dto.address());


        user = this.gateway.create(user);
        return this.mapper.fromDomainToOutputDTO(user);
    }
}

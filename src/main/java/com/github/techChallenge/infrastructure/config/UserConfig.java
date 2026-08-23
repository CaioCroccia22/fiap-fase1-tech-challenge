package com.github.techChallenge.infrastructure.config;

import com.github.techChallenge.application.gateways.UserGateway;
import com.github.techChallenge.application.usecases.user.*;
import com.github.techChallenge.application.validators.UserValidator;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.infrastructure.mappers.UserMapper;
import com.github.techChallenge.infrastructure.repositories.UserRepositoryGateway;
import com.github.techChallenge.infrastructure.security.ISecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUserUseCase createUserUseCase(UserGateway gateway, IUserMapper mapper) {
        return new CreateUserUseCase(gateway, mapper);
    }

    @Bean
    UpdateUserUseCase updateUserUseCase(UserGateway gateway, UserMapper mapper, UserValidator userValidator) {
        return new UpdateUserUseCase(gateway, mapper, userValidator);
    }

    @Bean
    FindUserUseCase findUserUseCase(UserGateway gateway, UserMapper mapper) {
        return new FindUserUseCase(gateway, mapper);
    }

    @Bean
    ListUserUseCase listUserUseCase(UserGateway gateway, UserMapper mapper) {
        return new ListUserUseCase(gateway, mapper);
    }

    @Bean
    DeleteUserUseCase deleteUserUseCase(UserGateway gateway, UserMapper mapper) {
        return new DeleteUserUseCase(gateway, mapper);
    }

    @Bean
    UserValidator UserValidator(UserGateway gateway, IUserMapper mapper) {
        return new UserValidator(gateway, mapper);
    }

    @Bean
    UserGateway userGateway(UserRepositoryGateway userRepositoryGateway, UserMapper userMapper, ISecurityConfig securityConfig) {
        return new UserGateway(userRepositoryGateway, userMapper, securityConfig);
    }

    @Bean
    UserRepositoryGateway userRepositoryGateway() {
        return new UserRepositoryGateway();
    }

    @Bean
    ChangePasswordUseCase changePasswordUser(UserGateway gateway, IUserMapper mapper){return new ChangePasswordUseCase(gateway, mapper);};

}

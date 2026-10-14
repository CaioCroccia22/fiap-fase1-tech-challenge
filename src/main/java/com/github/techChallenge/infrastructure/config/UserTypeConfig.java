package com.github.techChallenge.infrastructure.config;

import com.github.techChallenge.application.gateways.usertype.IUserTypeGateway;
import com.github.techChallenge.application.gateways.usertype.UserTypeGateway;
import com.github.techChallenge.application.usecases.usertype.*;
import com.github.techChallenge.application.validators.UserTypeValidator;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.infrastructure.mappers.UserTypeMapper;
import com.github.techChallenge.infrastructure.repositories.usertype.UserTypeRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserTypeConfig {

    @Bean
    CreateUserTypeUseCase createUserTypeUseCase(IUserTypeGateway gateway, IUserTypeMapper mapper, UserTypeValidator validator) {
        return new CreateUserTypeUseCase(gateway, mapper, validator);
    }

    @Bean
    UpdateUserTypeUseCase updateUserTypeUseCase(IUserTypeGateway gateway, UserTypeMapper mapper, UserTypeValidator userTypeValidator) {
        return new UpdateUserTypeUseCase(gateway, mapper, userTypeValidator);
    }

    @Bean
    FindUserTypeUseCase findUserTypeUseCase(IUserTypeGateway gateway, UserTypeMapper mapper) {
        return new FindUserTypeUseCase(gateway, mapper);
    }

    @Bean
    ListUserTypeUseCase listUserTypeUseCase(IUserTypeGateway gateway, UserTypeMapper mapper) {
        return new ListUserTypeUseCase(gateway, mapper);
    }

    @Bean
    DeleteUserTypeUseCase deleteUserTypeUseCase(IUserTypeGateway gateway, UserTypeMapper mapper) {
        return new DeleteUserTypeUseCase(gateway, mapper);
    }

    @Bean
    UserTypeValidator userTypeValidator(IUserTypeGateway gateway, IUserTypeMapper mapper) {
        return new UserTypeValidator(gateway, mapper);
    }

    @Bean
    UserTypeGateway userTypeGateway(UserTypeRepositoryGateway userTypeRepositoryGateway, UserTypeMapper userTypeMapper) {
        return new UserTypeGateway(userTypeRepositoryGateway, userTypeMapper);
    }

    @Bean
    UserTypeRepositoryGateway userTypeRepositoryGateway() {
        return new UserTypeRepositoryGateway();
    }

}

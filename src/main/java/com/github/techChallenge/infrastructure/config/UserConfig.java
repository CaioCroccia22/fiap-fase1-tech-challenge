package com.github.techChallenge.infrastructure.config;

import com.github.techChallenge.application.gateways.user.IUserGateway;
import com.github.techChallenge.application.gateways.user.UserGateway;
import com.github.techChallenge.application.repositories.IUserTypeRepository;
import com.github.techChallenge.application.usecases.user.*;
import com.github.techChallenge.application.validators.UserTypeValidator;
import com.github.techChallenge.application.validators.UserValidator;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.infrastructure.mappers.UserMapper;
import com.github.techChallenge.infrastructure.repositories.user.UserRepository;
import com.github.techChallenge.infrastructure.repositories.user.UserRepositoryGateway;
import com.github.techChallenge.infrastructure.security.ISecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUserUseCase createUserUseCase(IUserGateway gateway, IUserMapper mapper, ISecurityConfig securityConfig, UserValidator validator) {
        return new CreateUserUseCase(gateway, mapper, securityConfig, validator);
    }

    @Bean
    UpdateUserUseCase updateUserUseCase(IUserGateway gateway, UserMapper mapper, UserValidator userValidator) {
        return new UpdateUserUseCase(gateway, mapper, userValidator);
    }

    @Bean
    FindUserUseCase findUserUseCase(IUserGateway gateway, UserMapper mapper) {
        return new FindUserUseCase(gateway, mapper);
    }

    @Bean
    ListUserUseCase listUserUseCase(IUserGateway gateway, UserMapper mapper) {
        return new ListUserUseCase(gateway, mapper);
    }

    @Bean
    DeleteUserUseCase deleteUserUseCase(IUserGateway gateway, UserMapper mapper) {
        return new DeleteUserUseCase(gateway, mapper);
    }

    @Bean
    UserValidator UserValidator(IUserGateway gateway, IUserMapper mapper, ISecurityConfig securityConfig) {
        return new UserValidator(gateway, mapper, securityConfig);
    }

    @Bean
    UserGateway userGateway(UserRepositoryGateway userRepositoryGateway, UserMapper userMapper, ISecurityConfig securityConfig,
                            IUserTypeRepository userTypeRepository) {
        return new UserGateway(userRepositoryGateway, userMapper, securityConfig, userTypeRepository);
    }

    @Bean
    UserRepositoryGateway userRepositoryGateway(UserRepository repository, IUserMapper mapper, IUserTypeMapper userTypeMapper) {
        return new UserRepositoryGateway(repository, mapper, userTypeMapper);
    }

    @Bean
    ChangePasswordUseCase changePasswordUser(IUserGateway gateway, IUserMapper mapper, ISecurityConfig securityConfig){
        return new ChangePasswordUseCase(gateway, mapper, securityConfig);
    }

    @Bean
    GrantUserTypeUseCase grantUserTypeUseCase(IUserGateway gateway, IUserMapper mapper, UserValidator userValidator,
                          UserTypeValidator userTypeValidator) {
        return new GrantUserTypeUseCase(gateway, mapper, userValidator, userTypeValidator);
    }

}

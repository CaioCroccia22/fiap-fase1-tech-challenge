package com.github.techChallenge.infrastructure.config;


import com.github.techChallenge.application.gateways.user.IUserGateway;
import com.github.techChallenge.application.gateways.user.UserGateway;
import com.github.techChallenge.application.repositories.IUserTypeRepository;
import com.github.techChallenge.application.usecases.user.*;
import com.github.techChallenge.application.validators.UserTypeValidator;
import com.github.techChallenge.application.validators.UserValidator;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.infrastructure.repositories.user.UserRepository;
import com.github.techChallenge.infrastructure.repositories.user.UserRepositoryGateway;
import com.github.techChallenge.infrastructure.security.ISecurityConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class UserConfigTest {

    @Mock
    private IUserGateway gateway;

    @Mock
    private UserRepositoryGateway userRepositoryGateway;

    @Mock
    private UserRepository repository;

    @Mock
    private IUserTypeRepository userTypeRepository;

    @Mock
    private IUserMapper mapper;

    @Mock
    private IUserTypeMapper userTypeMapper;

    @Mock
    private ISecurityConfig securityConfig;

    @Mock
    private UserValidator validator;

    @Mock
    private UserTypeValidator userTypeValidator;

    private UserConfig config;

    @BeforeEach
    void setUp() {
        config = new UserConfig();
    }

    @Test
    @DisplayName("Deve criar o CreateUseCase")
    void deveCriarCreateUseCase(){

        CreateUserUseCase createUserUseCase = config.createUserUseCase(gateway, mapper, securityConfig, validator);

        Assertions.assertNotNull(createUserUseCase);
        Assertions.assertSame(gateway, ReflectionTestUtils.getField(createUserUseCase, "gateway"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(createUserUseCase, "mapper"));
        Assertions.assertSame(securityConfig, ReflectionTestUtils.getField(createUserUseCase, "securityConfig"));
        Assertions.assertSame(validator, ReflectionTestUtils.getField(createUserUseCase, "validator"));

    }

    @Test
    @DisplayName("Deve criar UpdateUserUseCase com gateway, mapper e validator")
    void deveGerarUpdateUserUseCase() {

        UpdateUserUseCase updateUserUseCase = config.updateUserUseCase(gateway, mapper, validator);


        Assertions.assertNotNull(updateUserUseCase);
        Assertions.assertSame(gateway, ReflectionTestUtils.getField(updateUserUseCase, "gateway"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(updateUserUseCase, "mapper"));
        Assertions.assertSame(validator, ReflectionTestUtils.getField(updateUserUseCase, "userValidator"));
    }

    @Test
    @DisplayName("Deve criar FindUserUseCase com gateway e mapper")
    void deveGerarFindUserUseCase() {

        FindUserUseCase findUserUseCase = config.findUserUseCase(gateway, mapper);


        Assertions.assertNotNull(findUserUseCase);
        Assertions.assertSame(gateway, ReflectionTestUtils.getField(findUserUseCase, "gateway"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(findUserUseCase, "mapper"));
    }

    @Test
    @DisplayName("Deve criar ListUserUseCase com gateway e mapper")
    void deveGerarListUserUseCase() {

        ListUserUseCase listUserUseCase = config.listUserUseCase(gateway, mapper);


        Assertions.assertNotNull(listUserUseCase);
        Assertions.assertSame(gateway, ReflectionTestUtils.getField(listUserUseCase, "gateway"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(listUserUseCase, "mapper"));
    }

    @Test
    @DisplayName("Deve criar DeleteUserUseCase com gateway e mapper")
    void deveGerarDeleteUserUseCase() {

        DeleteUserUseCase deleteUserUseCase = config.deleteUserUseCase(gateway, mapper);


        Assertions.assertNotNull(deleteUserUseCase);
        Assertions.assertSame(gateway, ReflectionTestUtils.getField(deleteUserUseCase, "gateway"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(deleteUserUseCase, "mapper"));
    }

    @Test
    @DisplayName("Deve criar UserValidator com gateway, mapper e securityConfig")
    void deveGerarUserValidator() {

        UserValidator userValidator = config.UserValidator(gateway, mapper, securityConfig);


        Assertions.assertNotNull(userValidator);
        Assertions.assertSame(gateway, ReflectionTestUtils.getField(userValidator, "gateway"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(userValidator, "mapper"));
        Assertions.assertSame(securityConfig, ReflectionTestUtils.getField(userValidator, "security"));
    }

    @Test
    @DisplayName("Deve criar UserGateway com userRepositoryGateway, mapper, securityConfig e userTypeRepository")
    void deveGerarUserGateway() {

        UserGateway userGateway =
                    config.userGateway(userRepositoryGateway, mapper, securityConfig, userTypeRepository);


        Assertions.assertNotNull(userGateway);
        Assertions.assertInstanceOf(IUserGateway.class, userGateway);
        Assertions.assertSame(userRepositoryGateway, ReflectionTestUtils.getField(userGateway, "repository"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(userGateway, "mapper"));
        Assertions.assertSame(securityConfig, ReflectionTestUtils.getField(userGateway, "securityConfig"));
        Assertions.assertSame(userTypeRepository, ReflectionTestUtils.getField(userGateway, "userTypeRepository"));
    }

    @Test
    @DisplayName("Deve criar UserRepositoryGateway com repository, mapper e userTypeMapper")
    void deveGerarUserRepositoryGateway() {
        // Act
        UserRepositoryGateway userRepositoryGateway = config.userRepositoryGateway(repository, mapper, userTypeMapper);

        // Assert
        Assertions.assertNotNull(userRepositoryGateway);
        Assertions.assertSame(repository, ReflectionTestUtils.getField(userRepositoryGateway, "repository"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(userRepositoryGateway, "mapper"));
        Assertions.assertSame(userTypeMapper, ReflectionTestUtils.getField(userRepositoryGateway, "userLevelMapper"));
    }

    @Test
    @DisplayName("Deve criar ChangePasswordUseCase com gateway, mapper e securityConfig")
    void deveGerarChangePasswordUseCase() {

        ChangePasswordUseCase changePasswordUseCase = config.changePasswordUser(gateway, mapper, securityConfig);


        Assertions.assertNotNull(changePasswordUseCase);
        Assertions.assertSame(gateway, ReflectionTestUtils.getField(changePasswordUseCase, "gateway"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(changePasswordUseCase, "mapper"));
        Assertions.assertSame(securityConfig, ReflectionTestUtils.getField(changePasswordUseCase, "securityConfig"));
    }

    @Test
    @DisplayName("Deve criar GrantUserTypeUseCase com gateway, mapper, userValidator e userTypeValidator")
    void deveGerarGrantUserTypeUseCase() {

        GrantUserTypeUseCase grantUserTypeUseCase = config.grantUserTypeUseCase(gateway, mapper, validator, userTypeValidator);


        Assertions.assertNotNull(grantUserTypeUseCase);
        Assertions.assertSame(gateway, ReflectionTestUtils.getField(grantUserTypeUseCase, "gateway"));
        Assertions.assertSame(mapper, ReflectionTestUtils.getField(grantUserTypeUseCase, "mapper"));
        Assertions.assertSame(validator, ReflectionTestUtils.getField(grantUserTypeUseCase, "userValidator"));
        Assertions.assertSame(userTypeValidator, ReflectionTestUtils.getField(grantUserTypeUseCase, "userTypeValidator"));
    }






}

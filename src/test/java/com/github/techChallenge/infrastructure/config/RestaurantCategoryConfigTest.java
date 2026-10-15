package com.github.techChallenge.infrastructure.config;


import com.github.techChallenge.application.gateways.restaurantCategory.IRestaurantCategoryGateway;
import com.github.techChallenge.application.gateways.restaurantCategory.RestaurantCategoryGateway;
import com.github.techChallenge.application.usecases.restaurantCategory.*;
import com.github.techChallenge.application.validators.RestaurantCategoryValidator;
import com.github.techChallenge.domain.restaurantCategory.IRestaurantCategoryMapper;
import com.github.techChallenge.infrastructure.mappers.RestaurantCategoryMapper;
import com.github.techChallenge.infrastructure.repositories.restaurantCategory.RestaurantCategoryRepositoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.List;

//Teste do RestaurantCategoryConfig
@ExtendWith(MockitoExtension.class)
public class RestaurantCategoryConfigTest {

    //Campos tem que estarem publicos para serem lidos
    @Mock
    private IRestaurantCategoryGateway gateway;

    @Mock
    private IRestaurantCategoryMapper mapperInterface;

    @Mock
    private RestaurantCategoryMapper mapper;

    @Mock
    private RestaurantCategoryValidator validator;

    @Mock
    private RestaurantCategoryRepositoryGateway repositoryGateway;

    private RestaurantCategoryConfig config;

    @BeforeEach
    void setUp() {
        config = new RestaurantCategoryConfig();
    }


    @Test
    @DisplayName("Deve criar CreateUserTypeUseCase com gateway, mapper e validator")
    void deveGerarCreateRestaurantCategoryUseCase() throws IllegalAccessException {
        //Arrange
        RestaurantCategoryConfig config = new RestaurantCategoryConfig();

        // Action
        var createRestaurantCategoryUseCase = config.createRestaurantCategoryUseCase(gateway, mapper);

        //Assert
        Assertions.assertNotNull(createRestaurantCategoryUseCase);
        Assertions.assertTrue(getFields(createRestaurantCategoryUseCase, gateway));
        Assertions.assertTrue(getFields(createRestaurantCategoryUseCase, mapper));

    }

    @Test
    @DisplayName("Deve criar UpdateRestaurantCategoryUseCase com gateway e mapper")
    void deveGerarUpdateRestaurantCategoryUseCase() throws IllegalAccessException {
        // Act
        UpdateRestaurantCategoryUseCase useCase = config.updateRestaurantCategoryUseCase(gateway, mapper, validator);

        // Assert
        Assertions.assertNotNull(useCase);
        Assertions.assertTrue(getFields(useCase, gateway));
        Assertions.assertTrue(getFields(useCase, mapper));
        Assertions.assertTrue(getFields(useCase, validator));
    }

    @Test
    @DisplayName("Deve criar FindRestaurantCategoryUseCase com gateway e mapper")
    void deveGerarFindRestaurantCategoryUseCase() throws IllegalAccessException {
        // Act
        FindRestaurantCategoryUseCase useCase = config.findRestaurantCategoryUseCase(gateway, mapper);

        // Assert
        Assertions.assertNotNull(useCase);
        Assertions.assertTrue(getFields(useCase, gateway));
        Assertions.assertTrue(getFields(useCase, mapper));
    }


    @Test
    @DisplayName("Deve criar ListRestaurantCategoryUseCase com gateway e mapper")
    void deveGerarListRestaurantCategoryUseCase() throws IllegalAccessException {
        // Act
        ListRestaurantCategoryUseCase useCase = config.listRestaurantCategoryUseCase(gateway, mapper);

        // Assert
        Assertions.assertNotNull(useCase);
        Assertions.assertTrue(getFields(useCase, gateway));
        Assertions.assertTrue(getFields(useCase, mapper));
    }

    @Test
    @DisplayName("Deve criar DeleteRestaurantCategoryUseCase com gateway e mapper")
    void deveGerarDeleteRestaurantCategoryUseCase() throws IllegalAccessException {
        // Act
        DeleteRestaurantCategoryUseCase useCase = config.deleteRestaurantCategoryUseCase(gateway, mapper);

        // Assert
        Assertions.assertNotNull(useCase);
        Assertions.assertTrue(getFields(useCase, gateway));
        Assertions.assertTrue(getFields(useCase, mapper));
    }

    @Test
    @DisplayName("Deve criar RestaurantCategoryValidator com gateway e mapper")
    void deveGerarRestaurantCategoryValidator() throws IllegalAccessException {
        // Act
        RestaurantCategoryValidator created = config.restaurantCategoryValidator(gateway, mapperInterface);

        // Assert
        Assertions.assertNotNull(created);
        Assertions.assertTrue(getFields(created, gateway));
        Assertions.assertTrue(getFields(created, mapperInterface));
    }

    @Test
    @DisplayName("Deve criar RestaurantCategoryGateway com repositoryGateway e mapper")
    void deveGerarRestaurantCategoryGateway() throws IllegalAccessException {
        // Act
        RestaurantCategoryGateway created = config.restaurantCategoryGateway(repositoryGateway, mapper);

        // Assert
        Assertions.assertNotNull(created);
        Assertions.assertInstanceOf(IRestaurantCategoryGateway.class, created);
        Assertions.assertTrue(getFields(created, repositoryGateway));
        Assertions.assertTrue(getFields(created, mapper));
    }

    @Test
    @DisplayName("Deve criar RestaurantCategoryRepositoryGateway")
    void deveGerarRestaurantCategoryRepositoryGateway() {
        // Act
        RestaurantCategoryRepositoryGateway created = config.restaurantCategoryRepositoryGateway();

        // Assert
        Assertions.assertNotNull(created);
    }



    private static boolean getFields(Object o, Object value) throws IllegalAccessException {
        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field f: fields){
            if(f.get(o) == value){
                return true;
            }
        }
        return false;
    }
}

package com.github.techChallenge.infrastructure.repositories.UserTypeRepository;


import com.github.techChallenge.application.exceptions.UserTypeNotFoundException;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.infrastructure.repositories.usertype.UserTypeRepository;
import com.github.techChallenge.infrastructure.repositories.usertype.UserTypeRepositoryGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = {"/00_cleanup-tables.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = {"/00_cleanup-tables.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Transactional
public class UserTypeRepositoryGatewayTest {


    @Autowired
    private UserTypeRepository repository;
    @Autowired
    private IUserTypeMapper mapper;
    @Autowired
    private UserTypeRepositoryGateway UserTypeRepositoryGateway;


    @Test
    @DisplayName("Deve inserir um tipo de usuário no banco de dados")
    public void shouldInsertUserTypeOnDataBase(){
            UserType userType = UserType.create("Usuário administrador");
            UserType saved = UserTypeRepositoryGateway.create(userType);

            assertNotNull(saved);
            assertInstanceOf(UserType.class,saved);


            assertNotNull(saved.getId());
            assertNotNull(saved.getTitle());
            assertEquals("Usuário administrador", saved.getTitle());
            assertEquals(saved.getTitle(), userType.getTitle());
    }

    @Test
    @DisplayName("Deve atualizar um tipo de usuário no banco de dados")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldUpdateUserTypeOnDataBase(){

        UserType userType = new UserType(1, "Fornecedor");

        UserType update = UserTypeRepositoryGateway.update(userType,
                                                            userType.getId());

        assertNotNull(update);
        assertInstanceOf(UserType.class,update);

        assertNotNull(update.getId());
        assertEquals(1, update.getId());
        assertEquals(update.getId(), userType.getId());

        assertNotNull(update.getTitle());
        assertEquals("Fornecedor", update.getTitle());
        assertEquals(update.getTitle(), userType.getTitle());
    }


    @Test
    @DisplayName("Deve encontrar um tipo de usuário no banco de dados pelo id")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldGetUserTypeByIdUserTypeOnDataBase(){

        UserType userType = new UserType(1, "Proprietário");

        UserType find = UserTypeRepositoryGateway.findByID(userType.getId());

        assertNotNull(find);
        assertInstanceOf(UserType.class,find);

        assertNotNull(find.getId());
        assertEquals(1, find.getId());
        assertEquals(find.getId(), userType.getId());

        assertNotNull(find.getTitle());
        assertEquals("Proprietário", find.getTitle());
        assertEquals(find.getTitle(), userType.getTitle());
    }


    @Test
    @DisplayName("Deve listar os tipos de usuários do banco de dados")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldListUserTypeOnDataBase(){

        Page<UserType> userTypes = UserTypeRepositoryGateway.list(0, 10);

        assertNotNull(userTypes);
        assertEquals(2, userTypes.getTotalElements());

        userTypes.forEach(userType -> {
            assertNotNull(userType.getId());
            assertNotNull(userType.getTitle());
        });

        UserType first = userTypes.getContent().getFirst();
        assertEquals(1, first.getId());
        assertEquals("Proprietário", first.getTitle());

        UserType last = userTypes.getContent().getLast();
        assertEquals(2, last.getId());
        assertEquals("Cliente", last.getTitle());

    }

    @Test
    @DisplayName("Deve deletar um tipo de usuário do banco de dados pelo id e lançar a exceção do usuário não encontrado")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldDeleteUserTypeOnDataBase(){

        int id = 1;

        UserTypeRepositoryGateway.delete(id);

        UserTypeNotFoundException e = assertThrows(UserTypeNotFoundException.class,
                () -> UserTypeRepositoryGateway.findByID(id));

        assertEquals("Nível de usuário não encontrado", e.getMessage());

    }


    @Test
    @DisplayName("Deve retornar true se não existe a descrição do tipo de usuário no banco de dados")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldReturnTrueIfExistsUserTypeByDescriptionOnDataBase(){
        assertTrue(UserTypeRepositoryGateway.existsByTitle("Proprietário"));
    }

    @Test
    @DisplayName("Deve retornar false se não existe a descrição do tipo de usuário no banco de dados")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldReturnFalseIfNotExistsUserTypeByDescriptionOnDataBase(){
        assertFalse(UserTypeRepositoryGateway.existsByTitle("Fornecedor"));

    }

    @Test
    @DisplayName("Deve retornar true se existe no banco de dados o tipo de usuário apenas pela descrição e não existe pelo id")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldReturnTrueIfExistsUserTypeByDescriptionAndIdNotOnDataBase(){
        assertTrue(UserTypeRepositoryGateway.existsByTitleAndIdNot("Proprietário", 10));

    }


    @Test
    @DisplayName("Deve retornar false se existe o tipo de usuário pela a descrição e o id que foi informado")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldReturnFalseIftExistsUserTypeWithDescriptionAndIdOnDataBase(){
        assertFalse(UserTypeRepositoryGateway.existsByTitleAndIdNot("Proprietário", 1));

    }


    @Test
    @DisplayName("Deve retornar true caso o Id exista no banco de dados")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldReturnTrueIfExistsUserTypeByIdOnDataBase(){
        assertTrue(UserTypeRepositoryGateway.existsById(1));

    }


    @Test
    @DisplayName("Deve retornar false caso o Id não exista no banco de dados")
    @Sql(scripts = "/01_users_type_samples.sql")
    public void shouldReturnFalseIfNotExistsUserTypeByIdOnDataBase(){
        assertFalse(UserTypeRepositoryGateway.existsById(10));

    }

}

package com.github.techChallenge.application.repositories;

import com.github.techChallenge.domain.user.User;
import org.springframework.data.domain.Page;

public interface IUserRepository {

    User create(User user);
    User update(User user, Long id);
    User findByID(Long id);

    Page<User> listByName(
            String name,
            int page,
            int offset
    );

    Page<User> list(
            int page,
            int offset
    );

    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
    void delete(Long id);
    String getEncryptPasswordByLogin(String login);
    boolean updatePasswordByLogin(String encryptPasword, String login);
    boolean existsByEmailAndIdNot(String email, Long id);
    boolean existsByLoginAndIdNot(String login, Long id);
    boolean existsById(Long id);
}
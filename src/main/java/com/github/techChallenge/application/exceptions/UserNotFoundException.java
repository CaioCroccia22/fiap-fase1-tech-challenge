package com.github.techChallenge.application.exceptions;


public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(Long id) {
        super("user-not-found", "Usuário não encontrado para o id " + id);
    }

    public UserNotFoundException(String message) {
        super("user-not-found", message);
    }
}

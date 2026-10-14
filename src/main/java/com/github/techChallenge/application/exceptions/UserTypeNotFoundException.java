package com.github.techChallenge.application.exceptions;

public class UserTypeNotFoundException extends BusinessException {

    public UserTypeNotFoundException(int id) {
        super("usertype-not-found", "Tipo de usuário não encontrado para o id " + id);
    }

    public UserTypeNotFoundException(String message) {
        super("usertype-not-found", message);
    }
}

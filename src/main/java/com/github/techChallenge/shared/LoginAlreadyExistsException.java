package com.github.techChallenge.shared;

public class LoginAlreadyExistsException extends ConflictException {

    public LoginAlreadyExistsException() {
        super(
                "USER_LOGIN_ALREADY_EXISTS",
                "Login já cadastrado",
                "Já existe um usuário cadastrado com este login."
        );
    }
}
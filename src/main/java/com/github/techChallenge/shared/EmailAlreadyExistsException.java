package com.github.techChallenge.shared;

public class EmailAlreadyExistsException extends ConflictException {

    public EmailAlreadyExistsException() {
        super(
                "USER_EMAIL_ALREADY_EXISTS",
                "E-mail já cadastrado",
                "Já existe um usuário cadastrado com este e-mail."
        );
    }
}
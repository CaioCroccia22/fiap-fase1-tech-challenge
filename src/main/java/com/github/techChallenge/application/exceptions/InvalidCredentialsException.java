package com.github.techChallenge.application.exceptions;


public class InvalidCredentialsException extends BusinessException {

    public InvalidCredentialsException() {
        super("invalid-credentials", "Login ou senha inválidos");
    }
}

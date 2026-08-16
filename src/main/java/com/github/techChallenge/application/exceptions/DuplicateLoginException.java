package com.github.techChallenge.application.exceptions;


public class DuplicateLoginException extends BusinessException {

    public DuplicateLoginException(String login) {
        super("duplicate-login", "O login " + login + " já está cadastrado para outro usuário");
    }
}

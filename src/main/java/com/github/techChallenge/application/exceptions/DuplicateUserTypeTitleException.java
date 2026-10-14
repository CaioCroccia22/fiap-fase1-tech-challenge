package com.github.techChallenge.application.exceptions;

public class DuplicateUserTypeTitleException extends BusinessException {

    public DuplicateUserTypeTitleException(String title) {
        super("duplicate-title", "O nome do tipo de usuário " + title + " já está cadastrado no sistema");
    }
}

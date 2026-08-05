package com.github.techChallenge.application.exceptions;


public class DuplicateEmailException extends BusinessException {

    public DuplicateEmailException(String email) {
        super("duplicate-email", "O e-mail " + email + " já está cadastrado para outro usuário");
    }
}

package com.github.techChallenge.shared;

import org.springframework.http.HttpStatus;

public abstract class UnauthorizedException extends ApplicationException {

    public UnauthorizedException() {
        super("401",
                "USER_UNAUTHORIZED",
                "Não é possivel alterar sem permissão, login ou senha incorretos");
    }
}
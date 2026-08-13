package com.github.techChallenge.shared;

public class UnauthorizedException extends ApplicationException {

    public UnauthorizedException() {
        super("USER_UNATHORIZED",
                "Usuário não autorizado",
                "Por favor verifique se o e-mail e senha estão corretos");
    }
}
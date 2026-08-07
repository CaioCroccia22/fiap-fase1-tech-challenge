package com.github.techChallenge.shared;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(Long id) {
        super(
                "USER_NOT_FOUND",
                "Usuário não encontrado",
                "Não foi encontrado um usuário com o ID " + id + "."
        );
    }
}
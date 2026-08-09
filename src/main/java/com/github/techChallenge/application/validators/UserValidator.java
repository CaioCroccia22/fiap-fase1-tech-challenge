package com.github.techChallenge.application.validators;

import com.github.techChallenge.application.gateways.UserGateway;
import com.github.techChallenge.application.usecases.user.UserUseCase;
import com.github.techChallenge.domain.user.IUserMapper;

public class UserValidator extends UserUseCase {

    public UserValidator(UserGateway gateway, IUserMapper mapper) {
        super(gateway, mapper);

    }

    public boolean validateLoginAndPassword(Long id, String password){
        return gateway.isValidLogin(gateway.find(id).getLogin(), password);
    }

}

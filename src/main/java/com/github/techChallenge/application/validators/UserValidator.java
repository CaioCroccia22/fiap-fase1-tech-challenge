package com.github.techChallenge.application.validators;

import com.github.techChallenge.application.gateways.UserGateway;
import com.github.techChallenge.application.usecases.user.UserUseCase;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.UserAuthInputDTO;

public class UserValidator extends UserUseCase {

    public UserValidator(UserGateway gateway, IUserMapper mapper){
        super(gateway, mapper);
    }

    public boolean authUser(UserAuthInputDTO dto){
        return this.gateway.validate(dto.password(), dto.login());
    }

}

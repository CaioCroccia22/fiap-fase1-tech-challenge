package com.github.techChallenge.application.usecases.user;

import com.github.techChallenge.application.gateways.UserGateway;
import com.github.techChallenge.domain.user.IUserMapper;

public class UserUseCase {
    protected final UserGateway gateway;
    protected final IUserMapper mapper;

    public UserUseCase(UserGateway gateway, IUserMapper mapper) {
        this.gateway = gateway;
        this.mapper = mapper;
    }

}

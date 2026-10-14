package com.github.techChallenge.application.usecases.usertype;

import com.github.techChallenge.application.gateways.usertype.IUserTypeGateway;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;

public class UserTypeUseCase {
    protected final IUserTypeGateway gateway;
    protected final IUserTypeMapper mapper;

    public UserTypeUseCase(IUserTypeGateway gateway, IUserTypeMapper mapper) {
        this.gateway = gateway;
        this.mapper = mapper;
    }

}

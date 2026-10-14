package com.github.techChallenge.application.usecases.usertype;

import com.github.techChallenge.application.gateways.usertype.IUserTypeGateway;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;

public class DeleteUserTypeUseCase extends UserTypeUseCase {

    public DeleteUserTypeUseCase(IUserTypeGateway gateway, IUserTypeMapper mapper) {
        super(gateway, mapper);
    }

    public void execute(int id) {
        this.gateway.delete(id);
    }
}

package com.github.techChallenge.application.usecases.user;

import com.github.techChallenge.application.gateways.UserGateway;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.UserCreateInputDTO;
import com.github.techChallenge.domain.user.dto.UserOutputDTO;

public class DeleteUserUseCase extends UserUseCase {

    public DeleteUserUseCase(UserGateway gateway, IUserMapper mapper) {
        super(gateway, mapper);
    }

    public void execute(Long id) {
        this.gateway.delete(id);
    }
}

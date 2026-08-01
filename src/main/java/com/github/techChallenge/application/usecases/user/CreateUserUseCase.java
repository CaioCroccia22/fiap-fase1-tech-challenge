package com.github.techChallenge.application.usecases.user;

import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.UserCreateInputDTO;
import com.github.techChallenge.domain.user.dto.UserOutputDTO;
import com.github.techChallenge.application.gateways.UserGateway;

public class CreateUserUseCase extends UserUseCase {

    public CreateUserUseCase(UserGateway gateway, IUserMapper mapper) {
        super(gateway, mapper);
    }

    public UserOutputDTO execute(UserCreateInputDTO dto) {
        User user = this.gateway.create(dto);
        return this.mapper.fromDomainToOutputDTO(user);
    }
}

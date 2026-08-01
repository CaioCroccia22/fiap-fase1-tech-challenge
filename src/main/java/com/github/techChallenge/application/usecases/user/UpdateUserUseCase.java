package com.github.techChallenge.application.usecases.user;

import com.github.techChallenge.application.gateways.UserGateway;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.UserCreateInputDTO;
import com.github.techChallenge.domain.user.dto.UserOutputDTO;
import com.github.techChallenge.domain.user.dto.UserUpdateInputDTO;

public class UpdateUserUseCase extends UserUseCase {

    public UpdateUserUseCase(UserGateway gateway, IUserMapper mapper) {
        super(gateway, mapper);
    }

    public UserOutputDTO execute(UserUpdateInputDTO dto, Long id) {
        User user = this.gateway.update(dto, id);
        return this.mapper.fromDomainToOutputDTO(user);
    }
}

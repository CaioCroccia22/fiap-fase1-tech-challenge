package com.github.techChallenge.application.usecases.user;

import com.github.techChallenge.application.gateways.UserGateway;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.dto.UserChangePasswordInputDTO;

public class ChangePasswordUseCase extends UserUseCase{
    public ChangePasswordUseCase(UserGateway gateway, IUserMapper mapper) {
        super(gateway, mapper);
    }

    public boolean ChangePassword(UserChangePasswordInputDTO dto){
        return this.gateway.changePassword(dto.password(), dto.login());
    }
}

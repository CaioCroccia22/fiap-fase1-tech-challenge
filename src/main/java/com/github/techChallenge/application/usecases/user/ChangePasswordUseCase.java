package com.github.techChallenge.application.usecases.user;

import com.github.techChallenge.application.gateways.user.IUserGateway;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.dto.UserChangePasswordInputDTO;
import com.github.techChallenge.infrastructure.security.ISecurityConfig;
import com.github.techChallenge.shared.UnauthorizedException;

public class ChangePasswordUseCase extends UserUseCase {
    private final ISecurityConfig securityConfig;

    public ChangePasswordUseCase(IUserGateway gateway, IUserMapper mapper, ISecurityConfig securityConfig) {
        super(gateway, mapper);
        this.securityConfig = securityConfig;
    }

    public boolean changePassword(UserChangePasswordInputDTO dto){
        if (!gateway.loginExists(dto.login())) {
            throw new UnauthorizedException() {};
        }
        String passwordEnconded = securityConfig.passwordEncoder(dto.password(), dto.login());
        return this.gateway.changePassword(passwordEnconded, dto.login());
    }
}

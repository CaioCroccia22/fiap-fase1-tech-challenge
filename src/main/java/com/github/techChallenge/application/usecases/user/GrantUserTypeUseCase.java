package com.github.techChallenge.application.usecases.user;

import com.github.techChallenge.application.exceptions.UserTypeNotFoundException;
import com.github.techChallenge.application.exceptions.UserNotFoundException;
import com.github.techChallenge.application.gateways.user.IUserGateway;
import com.github.techChallenge.application.validators.UserTypeValidator;
import com.github.techChallenge.application.validators.UserValidator;
import com.github.techChallenge.domain.user.IUserMapper;
import com.github.techChallenge.domain.user.User;
import com.github.techChallenge.domain.user.dto.GrantUserTypeInputDTO;
import com.github.techChallenge.domain.user.dto.UserOutputDTO;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;

public class GrantUserTypeUseCase extends UserUseCase {
    private final UserTypeValidator userTypeValidator;
    private final UserValidator userValidator;

    public GrantUserTypeUseCase(IUserGateway gateway, IUserMapper mapper, UserValidator userValidator,
                                UserTypeValidator userTypeValidator) {
        super(gateway, mapper);
        this.userValidator = userValidator;
        this.userTypeValidator = userTypeValidator;
    }

    public UserOutputDTO execute(GrantUserTypeInputDTO dto) {

        if (!this.userValidator.existsByID(dto.userID()))
            throw new UserNotFoundException("Usuário não encontrado");

        if (!this.userTypeValidator.existsByID(dto.userTypeID()))
            throw new UserTypeNotFoundException("Nível de usuário não encontrado pelo ID");

        User user = this.gateway.grantUserType(dto);
        return this.mapper.fromDomainToOutputDTO(user);
    }
}

package com.github.techChallenge.application.usecases.usertype;

import com.github.techChallenge.application.exceptions.DuplicateUserTypeTitleException;
import com.github.techChallenge.application.gateways.usertype.IUserTypeGateway;
import com.github.techChallenge.application.validators.UserTypeValidator;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.domain.usertype.dto.UserTypeCreateInputDTO;
import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;

public class CreateUserTypeUseCase extends UserTypeUseCase {

    private final UserTypeValidator validator;

    public CreateUserTypeUseCase(IUserTypeGateway gateway, IUserTypeMapper mapper, UserTypeValidator validator) {
        super(gateway, mapper);
        this.validator = validator;
    }

    public UserTypeOutputDTO execute(UserTypeCreateInputDTO dto) {

        if (validator.titleExists(dto.title()))
            throw new DuplicateUserTypeTitleException(dto.title());

        UserType userType = UserType.create(dto.title());

        userType = this.gateway.create(userType);
        return this.mapper.fromDomainToOutputDTO(userType);
    }
}

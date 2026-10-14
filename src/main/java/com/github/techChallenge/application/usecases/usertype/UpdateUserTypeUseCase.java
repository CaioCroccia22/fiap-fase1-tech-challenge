package com.github.techChallenge.application.usecases.usertype;

import com.github.techChallenge.application.exceptions.DuplicateUserTypeTitleException;
import com.github.techChallenge.application.exceptions.UserTypeNotFoundException;
import com.github.techChallenge.application.gateways.usertype.IUserTypeGateway;
import com.github.techChallenge.application.validators.UserTypeValidator;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;
import com.github.techChallenge.domain.usertype.dto.UserTypeUpdateInputDTO;

public class UpdateUserTypeUseCase extends UserTypeUseCase {
    private final UserTypeValidator userTypeValidator;

    public UpdateUserTypeUseCase(IUserTypeGateway gateway, IUserTypeMapper mapper, UserTypeValidator userTypeValidator) {
        super(gateway, mapper);
        this.userTypeValidator = userTypeValidator;
    }

    public UserTypeOutputDTO execute(UserTypeUpdateInputDTO dto, int id) {
        if (!this.gateway.existById(id)) throw new UserTypeNotFoundException("Nível de usuário não encontrado");

        if (this.userTypeValidator.titleExists(dto.title(), id))
            throw new DuplicateUserTypeTitleException(dto.title());

        UserType userType = new UserType(id, dto.title());

        userType = this.gateway.update(userType, id);
        return this.mapper.fromDomainToOutputDTO(userType);
    }
}

package com.github.techChallenge.application.usecases.usertype;

import com.github.techChallenge.application.gateways.usertype.IUserTypeGateway;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;

public class FindUserTypeUseCase extends UserTypeUseCase {

    public FindUserTypeUseCase(IUserTypeGateway gateway, IUserTypeMapper mapper) {
        super(gateway, mapper);
    }

    public UserTypeOutputDTO execute(int id) {
        UserType userType = this.gateway.find(id);
        return this.mapper.fromDomainToOutputDTO(userType);
    }
}

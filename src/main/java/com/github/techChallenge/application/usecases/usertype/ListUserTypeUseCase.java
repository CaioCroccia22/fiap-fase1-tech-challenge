package com.github.techChallenge.application.usecases.usertype;

import com.github.techChallenge.application.gateways.usertype.IUserTypeGateway;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;
import org.springframework.data.domain.Page;

public class ListUserTypeUseCase extends UserTypeUseCase {

    public ListUserTypeUseCase(IUserTypeGateway gateway, IUserTypeMapper mapper) {
        super(gateway, mapper);
    }

    public Page<UserTypeOutputDTO> execute(int page, int offset) {
        Page<UserType> userTypes = this.gateway.list(page, offset);
        return this.mapper.fromDomainPageToOutputDTOPage(userTypes);
    }
}

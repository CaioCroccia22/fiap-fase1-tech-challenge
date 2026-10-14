package com.github.techChallenge.application.validators;

import com.github.techChallenge.application.gateways.usertype.IUserTypeGateway;
import com.github.techChallenge.application.usecases.usertype.UserTypeUseCase;
import com.github.techChallenge.domain.usertype.IUserTypeMapper;

public class UserTypeValidator extends UserTypeUseCase {

    public UserTypeValidator(IUserTypeGateway gateway, IUserTypeMapper mapper){
        super(gateway, mapper);
    }

    public boolean titleExists(String title, int id) {
        return this.gateway.titleExists(title, id);
    }

    public boolean titleExists(String title) {
        return this.gateway.titleExists(title);
    }

    public boolean existsByID(int id) {return this.gateway.existById(id);}

}

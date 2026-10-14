package com.github.techChallenge.infrastructure.mappers;

import com.github.techChallenge.domain.usertype.IUserTypeMapper;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;
import com.github.techChallenge.infrastructure.entities.usertype.UserTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserTypeMapper implements IUserTypeMapper {
    @Override
    public UserType fromEntityToDomain(UserTypeEntity userTypeEntity) {
        if (Optional.ofNullable(userTypeEntity).isPresent()) {
            return new UserType(
                    userTypeEntity.getId(),
                    userTypeEntity.getTitle());
        }
        return null;
    }

    @Override
    public UserTypeOutputDTO fromDomainToOutputDTO(UserType userType) {
        if (Optional.ofNullable(userType).isPresent()) {
            return new UserTypeOutputDTO(
                    userType.getId(),
                    userType.getTitle());
        }

        return null;
    }

    @Override
    public UserTypeEntity fromDomainToEntity(UserType domain) {
        if (Optional.ofNullable(domain).isPresent()) {
            return new UserTypeEntity(domain);
        }
        return null;
    }

    @Override
    public Page<UserType> fromEntityPageToDomainPage(Page<UserTypeEntity> entitiesPage) {
        return entitiesPage.map(u -> {
            return new UserType(
                u.getId(),
                u.getTitle());
        });
    }

    @Override
    public Page<UserTypeOutputDTO> fromDomainPageToOutputDTOPage(Page<UserType> domainPage) {
        return domainPage.map(u -> {
            return new UserTypeOutputDTO(
                u.getId(),
                u.getTitle());
        });
    }

}

package com.github.techChallenge.domain.usertype;

import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;
import com.github.techChallenge.infrastructure.entities.usertype.UserTypeEntity;
import org.springframework.data.domain.Page;

public interface IUserTypeMapper {
    UserType fromEntityToDomain(UserTypeEntity userTypeEntity);
    UserTypeOutputDTO fromDomainToOutputDTO(UserType user);
    UserTypeEntity fromDomainToEntity(UserType domain);
    Page<UserType> fromEntityPageToDomainPage(Page<UserTypeEntity> entitiesPage);
    Page<UserTypeOutputDTO> fromDomainPageToOutputDTOPage(Page<UserType> domainPage);
}

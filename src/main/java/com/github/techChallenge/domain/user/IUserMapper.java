package com.github.techChallenge.domain.user;

import com.github.techChallenge.domain.user.dto.UserOutputDTO;
import com.github.techChallenge.infrastructure.entities.user.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserMapper {
    User fromEntityToDomain(UserEntity userEntity);
    UserOutputDTO fromDomainToOutputDTO(User user);
    Page<User> fromEntityPageToDomainPage(Page<UserEntity> entitiesPage);
    Page<UserOutputDTO> fromDomainPageToOutputDTOPage(Page<User> domainPage);
}

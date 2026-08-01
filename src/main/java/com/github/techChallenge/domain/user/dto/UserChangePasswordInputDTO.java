package com.github.techChallenge.domain.user.dto;

import com.github.techChallenge.domain.user.Address;
import com.github.techChallenge.domain.user.UserLevel;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserChangePasswordInputDTO(
    @Schema(description = "ID do usuário", example = "1", format= "integer", requiredMode = Schema.RequiredMode.REQUIRED)
    Long id,
    @Schema(description = "Nova senha a ser atribuida ao usuário", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String password) {
}

package com.github.techChallenge.domain.user.dto;

import com.github.techChallenge.domain.user.Address;
import com.github.techChallenge.domain.user.UserLevel;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserChangePasswordInputDTO(
    @Schema(description = "Login do usuário", example = "jose.silva", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String login,
    @Schema(description = "Nova senha a ser atribuida ao usuário", example = "Senha@1234",format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String password) {
}

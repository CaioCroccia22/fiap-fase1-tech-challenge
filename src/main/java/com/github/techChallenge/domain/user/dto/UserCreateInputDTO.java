package com.github.techChallenge.domain.user.dto;

import com.github.techChallenge.domain.user.Address;
import com.github.techChallenge.domain.user.UserLevel;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserCreateInputDTO(
    @Schema(description = "Nome completo do usuário", example = "José da Silva", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String name,
    @Schema(description = "Nome de usuário de acesso ao sistema", example = "jose.silva", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String login,
    @Schema(description = "Nivel de acesso deste usuário.", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    UserLevel level,
    @Schema(description = "Endereço do usuário")
    Address address) {
}

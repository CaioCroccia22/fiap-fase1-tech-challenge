package com.github.techChallenge.domain.user.dto;

import com.github.techChallenge.domain.user.Address;
import com.github.techChallenge.domain.user.UserLevel;
import com.github.techChallenge.domain.usertype.UserType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record UserUpdateOutputDTO(
    @Schema(description = "ID do usuário", example = "1", format= "integer")
    Long id,
    @Schema(description = "Nome completo do usuário", example = "José da Silva", format= "string")
    String name,
    @Schema(description = "Nome de usuário de acesso ao sistema", example = "jose.silva", format= "string")
    String login,
    @Schema(description = "Nível de acesso do usuário", allowableValues = {"OWNER", "CUSTOMER"})
    UserLevel userLevel,
    @Schema(description = "Tipo de usuário.", implementation= UserType.class)
    UserType userType,
    @Schema(description = "Endereço do usuário", implementation = Address.class)
    Address address,
    @Schema(description = "Data e hora do momento da criação, no formato YYYY-MM-DD HH:mm:ss", example = "2026-07-29 19:04:23", format= "string")
    LocalDateTime createdAt,
    @Schema(description = "Data e hora do momento da última atualização, no formato YYYY-MM-DD HH:mm:ss", example = "2026-07-29 19:29:55", format= "string")
    LocalDateTime updated_at) {
}

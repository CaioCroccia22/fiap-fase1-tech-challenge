package com.github.techChallenge.domain.user.dto;

import com.github.techChallenge.domain.user.Address;
import com.github.techChallenge.domain.user.UserLevel;
import com.github.techChallenge.domain.usertype.UserType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record UserCreateOutputDTO(
    @Schema(description = "ID do usuário, gerado durante a criação", example = "1", format= "integer")
    Long id,
    @Schema(description = "Nome completo do usuário", example = "José da Silva", format= "string")
    String name,
    @Schema(description = "Nome de usuário de acesso ao sistema", example = "jose.silva", format= "string")
    String login,
    @Schema(description = "Nível de usuário.", allowableValues= {"CUSTOMER", "OWNER"})
    UserLevel userLevel,
    @Schema(description = "Tipo de usuário.", implementation= UserType.class)
    UserType type,
    @Schema(description = "Endereço do usuário", implementation = Address.class)
    Address address,
    @Schema(description = "Data e hora do momento da criação, no formato YYYY-MM-DD HH:mm:ss", example = "2026-07-29 19:04:23", format= "string")
    LocalDateTime createdAt) {
}

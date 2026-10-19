package com.github.techChallenge.domain.user.dto;

import com.github.techChallenge.domain.user.Address;
import com.github.techChallenge.domain.user.UserLevel;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserCreateInputDTO(

        @Schema(
                description = "Nome completo do usuário",
                example = "José da Silva",
                maxLength = 50,
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String name,

        @Schema(
                description = "E-mail do usuário",
                example = "jose.silva@email.com",
                format = "email",
                maxLength = 255,
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String email,

        @Schema(
                description = "Login do usuário",
                example = "jose.silva",
                minLength = 4,
                maxLength = 100,
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String login,

        @Schema(
                description = "Senha do usuário",
                example = "Senha@123",
                minLength = 8,
                maxLength = 100,
                requiredMode = Schema.RequiredMode.REQUIRED,
                accessMode = Schema.AccessMode.WRITE_ONLY
        )
        String password,

        @Schema(
                description = "Endereço do usuário",
                implementation = Address.class,
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Address address,

        @Schema(
                description = "Nível de usuário",
                allowableValues = {"OWNER", "CUSTOMER"},
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        UserLevel userLevel

) {
}
package com.github.techChallenge.domain.user.dto;

import com.github.techChallenge.domain.user.Address;
import com.github.techChallenge.domain.user.UserLevel;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserUpdateInputDTO(

        @Schema(
                description = "Nome completo do usuário",
                example = "José da Silva",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String name,

        @Schema(
                description = "E-mail do usuário",
                example = "jose.silva@email.com",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String email,

        @Schema(
                description = "Nome de usuário para acesso ao sistema",
                example = "jose.silva",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String login,

        @Schema(
                description = "Nível de acesso do usuário",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        UserLevel level,

        @Schema(
                description = "Endereço do usuário",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Address address

) {
}
package com.github.techChallenge.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserAuthInputDTO(
        @Schema(
                description = "Login do usuário",
                example = "jose.silva"
        )
        @NotBlank(message = "O login é obrigatório.")
        @Size(
                min = 4,
                max = 100,
                message = "O login deve possuir entre 4 e 100 caracteres."
        )
        String login,

        @Schema(
                description = "Senha do usuário",
                example = "Senha@123",
                accessMode = Schema.AccessMode.WRITE_ONLY
        )
        @NotBlank(message = "A senha é obrigatória.")
        @Size(
                min = 8,
                max = 100,
                message = "A senha deve possuir entre 8 e 100 caracteres."
        )
                String password
) {

}

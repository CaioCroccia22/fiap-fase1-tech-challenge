package com.github.techChallenge.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserChangePasswordInputDTO(
    @Schema(description = "Login do usuário", example = "jose.silva", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O login é obrigatório.")
    String login,

    @Schema(description = "Nova senha a ser atribuida ao usuário", example = "Senha@1234",format= "string", requiredMode = Schema.RequiredMode.REQUIRED, accessMode = Schema.AccessMode.WRITE_ONLY)
    @NotBlank(message = "A senha é obrigatória.")
    @Size(
        min = 8,
        max = 100,
        message = "A senha deve possuir entre 8 e 100 caracteres."
    )
    String password) {
}

package com.github.techChallenge.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record GrantUserTypeInputDTO(
        @Schema(
                description = "ID do usuário",
                example = "1",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "O ID do usuário é obrigatório")
        Long userID,

        @Schema(
                description = "ID do tipo de usuário",
                example = "1",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "O ID do tipo de usuário é obrigatório.")
        int userTypeID
) {
}
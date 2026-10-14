package com.github.techChallenge.domain.usertype.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserTypeOutputDTO(

        @Schema(description = "ID do tipo do usuário", example = "1")
        int id,

        @Schema(description = "Título do tipo do usuário", example = "Proprietário")
        String title) {
}
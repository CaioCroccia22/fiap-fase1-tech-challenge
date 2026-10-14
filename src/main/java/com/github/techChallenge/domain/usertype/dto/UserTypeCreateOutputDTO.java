package com.github.techChallenge.domain.usertype.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserTypeCreateOutputDTO(
    @Schema(description = "ID do tipo do usuário, gerado durante a criação", example = "1", format= "integer")
    int id,
    @Schema(description = "Título do tipo", example = "Proprietário", format= "string")
    String title) {
}

package com.github.techChallenge.domain.usertype.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserTypeUpdateOutputDTO(
    @Schema(description = "ID do tipo do usuário", example = "1", format= "integer")
    int id,
    @Schema(description = "Título do tipo do usuário", example = "Proprietário", format= "string")
    String title) {
}

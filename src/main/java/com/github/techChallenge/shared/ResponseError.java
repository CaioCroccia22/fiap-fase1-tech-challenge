package com.github.techChallenge.shared;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Resposta de erro")
public record ResponseError(
    @Schema(description = "Código HTTP do erro")
    int statusCode,
    @Schema(description = "Descrição do erro")
    String errorMessage,
    @Schema(description = "Lista de erros em caso de validação", nullable = true)
    List<String> errors) {
}

package com.github.techChallenge.shared;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;
import java.util.Map;

@Schema(
    name = "ApiErrorResponse",
    description = "Resposta de erro no padrão RFC 7807 (Problem Details for HTTP APIs)"
)
public record ApiErrorResponse(

    @Schema(
        description = "URI que identifica o tipo do problema",
        example = "/problems/validation-error"
    )
    String type,

    @Schema(
        description = "Resumo legível do tipo do problema",
        example = "Dados inválidos"
    )
    String title,

    @Schema(
        description = "Código HTTP da resposta",
        example = "400"
    )
    int status,

    @Schema(
        description = "Explicação específica desta ocorrência do problema",
        example = "Um ou mais campos da requisição são inválidos."
    )
    String detail,

    @Schema(
        description = "URI da requisição que originou o erro",
        example = "/api/v1/user/"
    )
    String instance,

    @Schema(
        description = "Código interno do erro, para tratamento programático",
        example = "VALIDATION_ERROR"
    )
    String code,

    @Schema(
        description = "Momento em que o erro ocorreu",
        example = "2026-08-16T12:37:33.464-03:00"
    )
    OffsetDateTime timestamp,

    @Schema(
        description = "Campos que violaram regras de validação, "
                    + "no formato campo/mensagem. Presente apenas em erros de validação.",
        example = "{\"email\": \"O e-mail possui formato inválido.\"}",
        nullable = true
    )
    Map<String, String> violations

) {
}

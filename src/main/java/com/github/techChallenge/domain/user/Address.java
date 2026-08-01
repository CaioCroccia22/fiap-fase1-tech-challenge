package com.github.techChallenge.domain.user;

import io.swagger.v3.oas.annotations.media.Schema;

public record Address (
    @Schema(description = "Logradouro", example = "Avenida Paulista", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String address,
    @Schema(description = "Número do endereço", example = "1000", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String number,
    @Schema(description = "Complemento, se houver", example = "3° andar, sala 300", format= "string", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    String complement,
    @Schema(description = "CEP", example = "01000-100", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String zipCode,
    @Schema(description = "Bairro", example = "Cerqueira Cesar", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String neighborhood,
    @Schema(description = "Cidade", example = "São Paulo", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String city,
    @Schema(description = "UF, com 2 caracteres", example = "SP", format= "string", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 2)
    String state,
    @Schema(description = "País", example = "Brasil", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    String country
) {

}

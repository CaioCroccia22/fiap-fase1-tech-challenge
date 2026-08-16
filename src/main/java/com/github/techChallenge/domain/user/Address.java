package com.github.techChallenge.domain.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record Address (
    @Schema(description = "Logradouro", example = "Avenida Paulista", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O logradouro é obrigatório")
    String address,
    @Schema(description = "Número do endereço", example = "1000", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O número é obrigatório")
    String number,
    @Schema(description = "Complemento, se houver", example = "3° andar, sala 300", format= "string", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    String complement,
    @Schema(description = "CEP", example = "01000-100", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message="O padrão para o CEP é 99999-999 ou 99999999")
    String zipCode,
    @Schema(description = "Bairro", example = "Cerqueira Cesar", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O bairro é obrigatório")
    String neighborhood,
    @Schema(description = "Cidade", example = "São Paulo", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "A cidade é obrigatória")
    String city,
    @Schema(description = "UF, com 2 caracteres", example = "SP", format= "string", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 2)
    @NotBlank(message = "O UF é obrigatório")
    @Pattern(regexp = "^[A-Z]{2}$", message = "O estado informado deve ser a sigla do mesmo com 2 caracteres")
    String state,
    @Schema(description = "País", example = "Brasil", format= "string", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O país é obrigatório")
    String country
) {

}

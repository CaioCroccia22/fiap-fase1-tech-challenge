package com.github.techChallenge.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.techChallenge.domain.user.Address;
import com.github.techChallenge.domain.user.UserLevel;
import com.github.techChallenge.domain.usertype.UserType;
import com.github.techChallenge.domain.usertype.dto.UserTypeOutputDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record UserOutputDTO(

        @Schema(description = "ID do usuário", example = "1")
        Long id,

        @Schema(description = "Nome completo do usuário", example = "José da Silva")
        String name,

        @Schema(description = "E-mail do usuário", example = "jose.silva@email.com")
        String email,

        @Schema(description = "Nome de usuário", example = "jose.silva")
        String login,

        @Schema(description = "Nível de acesso do usuário", allowableValues = {"OWNER", "CUSTOMER"})
        UserLevel userLevel,

        @Schema(description = "Tipo de usuário", implementation = UserTypeOutputDTO.class)
        UserTypeOutputDTO type,

        @Schema(description = "Endereço do usuário", implementation = Address.class)
        Address address,

        @Schema(
                description = "Data de criação do usuário",
                example = "2026-08-05T22:30:00.658"
        )
        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS"
        )
        LocalDateTime createdAt,

        @Schema(
                description = "Data da última atualização do usuário",
                example = "2026-08-05T22:45:00.658"
        )
        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS"
        )
        LocalDateTime updatedAt

) {
}
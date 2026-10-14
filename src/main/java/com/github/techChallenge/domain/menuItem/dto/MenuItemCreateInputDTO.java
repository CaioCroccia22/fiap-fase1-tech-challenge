package com.github.techChallenge.domain.menuItem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record MenuItemCreateInputDTO(

        @Schema(description = "Nome do item do cardápio", example = "X-Burger")
        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 100, message = "O nome deve possuir no máximo 100 caracteres.")
        String name,

        @Schema(description = "Descrição do item", example = "Pão, hambúrguer e queijo")
        @Size(max = 255, message = "A descrição deve possuir no máximo 255 caracteres.")
        String description,

        @Schema(description = "Preço do item", example = "29.90")
        @NotNull(message = "O preço é obrigatório.")
        @Positive(message = "O preço deve ser maior que zero.")
        BigDecimal price,

        @Schema(description = "Indica se o item só pode ser pedido no restaurante", example = "false")
        @NotNull(message = "A disponibilidade é obrigatória.")
        Boolean dineInOnly,

        @Schema(description = "Caminho da foto do prato", example = "/fotos/x-burger.png")
        @Size(max = 255, message = "O caminho da foto deve possuir no máximo 255 caracteres.")
        String photoPath,

        // TODO: só é validado como obrigatório; a existência do restaurante ainda não é checada (módulo Restaurant não existe).
        @Schema(description = "ID do restaurante dono do item", example = "1")
        @NotNull(message = "O restaurante é obrigatório.")
        Long restaurantId) {
}

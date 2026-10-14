package com.github.techChallenge.domain.menuItem.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record MenuItemOutputDTO(

        @Schema(description = "ID do item do cardápio", example = "1")
        Long id,

        @Schema(description = "Nome do item do cardápio", example = "X-Burger")
        String name,

        @Schema(description = "Descrição do item", example = "Pão, hambúrguer e queijo")
        String description,

        @Schema(description = "Preço do item", example = "29.90")
        BigDecimal price,

        @Schema(description = "Indica se o item só pode ser pedido no restaurante", example = "false")
        boolean dineInOnly,

        @Schema(description = "Caminho da foto do prato", example = "/fotos/x-burger.png")
        String photoPath,

        @Schema(description = "ID do restaurante dono do item", example = "1")
        Long restaurantId) {
}

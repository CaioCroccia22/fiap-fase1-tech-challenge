package com.github.techChallenge.domain.menuItem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    @DisplayName("Deve criar um item sem id e com o nome sem espaços nas pontas")
    void shouldCreateMenuItem() {
        // Arrange
        String nameWithSpaces = "  X-Burger ";

        // Act
        MenuItem menuItem = MenuItem.create(nameWithSpaces, "Pão e carne",
                new BigDecimal("29.90"), true, "/fotos/x-burger.png", 7L);

        // Assert
        assertNull(menuItem.getId());
        assertEquals("X-Burger", menuItem.getName());
        assertEquals("Pão e carne", menuItem.getDescription());
        assertEquals(new BigDecimal("29.90"), menuItem.getPrice());
        assertTrue(menuItem.isDineInOnly());
        assertEquals("/fotos/x-burger.png", menuItem.getPhotoPath());
        assertEquals(7L, menuItem.getRestaurantId());
    }

    @Test
    @DisplayName("Deve atualizar os dados do item mantendo id e restaurante")
    void shouldUpdateMenuItem() {
        // Arrange
        MenuItem menuItem = new MenuItem(1L, "X-Burger", "Pão e carne",
                new BigDecimal("29.90"), true, "/fotos/x-burger.png", 7L);

        // Act
        menuItem.update(" X-Salada ", "Pão, carne e salada",
                new BigDecimal("32.00"), false, "/fotos/x-salada.png");

        // Assert
        assertEquals(1L, menuItem.getId());
        assertEquals(7L, menuItem.getRestaurantId());
        assertEquals("X-Salada", menuItem.getName());
        assertEquals("Pão, carne e salada", menuItem.getDescription());
        assertEquals(new BigDecimal("32.00"), menuItem.getPrice());
        assertFalse(menuItem.isDineInOnly());
        assertEquals("/fotos/x-salada.png", menuItem.getPhotoPath());
    }
}

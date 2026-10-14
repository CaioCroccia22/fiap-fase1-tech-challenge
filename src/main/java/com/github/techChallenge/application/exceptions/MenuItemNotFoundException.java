package com.github.techChallenge.application.exceptions;

public class MenuItemNotFoundException extends BusinessException {

    public MenuItemNotFoundException(Long id) {
        super("menu-item-not-found", "Item do cardápio não encontrado para o id " + id);
    }

    public MenuItemNotFoundException(String message) {
        super("menu-item-not-found", message);
    }
}

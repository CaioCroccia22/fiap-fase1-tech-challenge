package com.github.techChallenge.application.exceptions;

public class DuplicateMenuItemNameException extends BusinessException {

    public DuplicateMenuItemNameException(String name) {
        super("duplicate-menu-item-name", "O item " + name + " já está cadastrado no cardápio deste restaurante");
    }
}

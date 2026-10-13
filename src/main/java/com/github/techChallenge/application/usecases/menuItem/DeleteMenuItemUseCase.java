package com.github.techChallenge.application.usecases.menuItem;

import com.github.techChallenge.application.exceptions.MenuItemNotFoundException;
import com.github.techChallenge.application.gateways.menuItem.IMenuItemGateway;
import com.github.techChallenge.domain.menuItem.IMenuItemMapper;

public class DeleteMenuItemUseCase extends MenuItemUseCase {

    public DeleteMenuItemUseCase(IMenuItemGateway gateway, IMenuItemMapper mapper) {
        super(gateway, mapper);
    }

    public void execute(Long id) {
        if (!this.gateway.existById(id)) throw new MenuItemNotFoundException(id);

        this.gateway.delete(id);
    }
}

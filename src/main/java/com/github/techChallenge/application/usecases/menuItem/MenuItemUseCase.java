package com.github.techChallenge.application.usecases.menuItem;

import com.github.techChallenge.application.gateways.menuItem.IMenuItemGateway;
import com.github.techChallenge.domain.menuItem.IMenuItemMapper;

public class MenuItemUseCase {
    protected final IMenuItemGateway gateway;
    protected final IMenuItemMapper mapper;

    public MenuItemUseCase(IMenuItemGateway gateway, IMenuItemMapper mapper) {
        this.gateway = gateway;
        this.mapper = mapper;
    }

}

package com.github.techChallenge.application.usecases.menuItem;

import com.github.techChallenge.application.exceptions.DuplicateMenuItemNameException;
import com.github.techChallenge.application.gateways.menuItem.IMenuItemGateway;
import com.github.techChallenge.domain.menuItem.IMenuItemMapper;
import com.github.techChallenge.domain.menuItem.MenuItem;
import com.github.techChallenge.domain.menuItem.dto.MenuItemCreateInputDTO;
import com.github.techChallenge.domain.menuItem.dto.MenuItemOutputDTO;

public class CreateMenuItemUseCase extends MenuItemUseCase {

    public CreateMenuItemUseCase(IMenuItemGateway gateway, IMenuItemMapper mapper) {
        super(gateway, mapper);
    }

    public MenuItemOutputDTO execute(MenuItemCreateInputDTO dto) {
        // TODO: o módulo Restaurant ainda não existe, então o restaurantId não é validado aqui.
        // Quando existir, checar se o restaurante existe e lançar RestaurantNotFoundException.
        MenuItem menuItem = MenuItem.create(
                dto.name(),
                dto.description(),
                dto.price(),
                dto.dineInOnly(),
                dto.photoPath(),
                dto.restaurantId()
        );

        if (this.gateway.nameExists(menuItem.getName(), menuItem.getRestaurantId()))
            throw new DuplicateMenuItemNameException(menuItem.getName());

        menuItem = this.gateway.create(menuItem);
        return this.mapper.fromDomainToOutputDTO(menuItem);
    }
}

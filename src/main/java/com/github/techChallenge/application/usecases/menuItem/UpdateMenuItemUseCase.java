package com.github.techChallenge.application.usecases.menuItem;

import com.github.techChallenge.application.exceptions.DuplicateMenuItemNameException;
import com.github.techChallenge.application.exceptions.MenuItemNotFoundException;
import com.github.techChallenge.application.gateways.menuItem.IMenuItemGateway;
import com.github.techChallenge.domain.menuItem.IMenuItemMapper;
import com.github.techChallenge.domain.menuItem.MenuItem;
import com.github.techChallenge.domain.menuItem.dto.MenuItemOutputDTO;
import com.github.techChallenge.domain.menuItem.dto.MenuItemUpdateInputDTO;

public class UpdateMenuItemUseCase extends MenuItemUseCase {

    public UpdateMenuItemUseCase(IMenuItemGateway gateway, IMenuItemMapper mapper) {
        super(gateway, mapper);
    }

    public MenuItemOutputDTO execute(MenuItemUpdateInputDTO dto, Long id) {
        if (!this.gateway.existById(id)) throw new MenuItemNotFoundException(id);

        MenuItem menuItem = this.gateway.find(id);
        menuItem.update(
                dto.name(),
                dto.description(),
                dto.price(),
                dto.dineInOnly(),
                dto.photoPath()
        );

        if (this.gateway.nameExists(menuItem.getName(), menuItem.getRestaurantId(), id))
            throw new DuplicateMenuItemNameException(menuItem.getName());

        menuItem = this.gateway.update(menuItem, id);
        return this.mapper.fromDomainToOutputDTO(menuItem);
    }
}

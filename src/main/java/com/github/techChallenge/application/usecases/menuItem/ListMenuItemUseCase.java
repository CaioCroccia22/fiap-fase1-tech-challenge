package com.github.techChallenge.application.usecases.menuItem;

import com.github.techChallenge.application.gateways.menuItem.IMenuItemGateway;
import com.github.techChallenge.domain.menuItem.IMenuItemMapper;
import com.github.techChallenge.domain.menuItem.MenuItem;
import com.github.techChallenge.domain.menuItem.dto.MenuItemOutputDTO;
import org.springframework.data.domain.Page;

public class ListMenuItemUseCase extends MenuItemUseCase {

    public ListMenuItemUseCase(IMenuItemGateway gateway, IMenuItemMapper mapper) {
        super(gateway, mapper);
    }

    public Page<MenuItemOutputDTO> execute(Long restaurantId, int page, int offset) {
        // TODO: o restaurantId não é validado (módulo Restaurant não existe); um id inexistente devolve página vazia.
        Page<MenuItem> menuItems = this.gateway.listByRestaurant(restaurantId, page, offset);
        return this.mapper.fromDomainPageToOutputDTOPage(menuItems);
    }
}

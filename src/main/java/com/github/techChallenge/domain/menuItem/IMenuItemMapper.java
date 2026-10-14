package com.github.techChallenge.domain.menuItem;

import com.github.techChallenge.domain.menuItem.dto.MenuItemOutputDTO;
import org.springframework.data.domain.Page;

public interface IMenuItemMapper {
    MenuItemOutputDTO fromDomainToOutputDTO(MenuItem domain);
    Page<MenuItemOutputDTO> fromDomainPageToOutputDTOPage(Page<MenuItem> domainPage);
}

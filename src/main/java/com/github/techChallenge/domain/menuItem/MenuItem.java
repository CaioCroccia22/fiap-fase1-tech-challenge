package com.github.techChallenge.domain.menuItem;

import java.math.BigDecimal;

public class MenuItem {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean dineInOnly;
    private String photoPath;
    private Long restaurantId;

    public MenuItem() {
    }

    public MenuItem(
            Long id,
            String name,
            String description,
            BigDecimal price,
            boolean dineInOnly,
            String photoPath,
            Long restaurantId
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dineInOnly = dineInOnly;
        this.photoPath = photoPath;
        this.restaurantId = restaurantId;
    }

    public static MenuItem create(
            String name,
            String description,
            BigDecimal price,
            boolean dineInOnly,
            String photoPath,
            Long restaurantId
    ) {
        return new MenuItem(
                null,
                name.trim(),
                description,
                price,
                dineInOnly,
                photoPath,
                restaurantId
        );
    }

    public void update(
            String name,
            String description,
            BigDecimal price,
            boolean dineInOnly,
            String photoPath
    ) {
        this.name = name.trim();
        this.description = description;
        this.price = price;
        this.dineInOnly = dineInOnly;
        this.photoPath = photoPath;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isDineInOnly() {
        return dineInOnly;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }
}

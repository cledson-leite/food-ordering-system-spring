package com.cledsonleite.orderservice.application.core.domain.entity;

import com.cledsonleite.orderservice.application.core.domain.valueObject.RestaurantId;

import java.util.List;
import java.util.UUID;

public class Restaurant extends AggregateRoot<RestaurantId> {

    private List<Product> products;
    private boolean isActive;

    public Restaurant() {
        super(new RestaurantId(UUID.randomUUID()));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

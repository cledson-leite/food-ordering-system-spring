package com.cledsonleite.orderservice.application.core.domain.entity;

import com.cledsonleite.orderservice.application.core.domain.valueObject.RestaurantId;

import java.util.List;

public class Restaurant extends AggregateRoot<RestaurantId> {

    private List<Product> products;
    private boolean isActive;

    public Restaurant(RestaurantId id, List<Product> products, boolean isActive) {
        super(id);
        this.products = products;
        this.isActive = isActive;
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

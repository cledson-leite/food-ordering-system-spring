package com.cledsonleite.orderservice.application.core.domain.builder;

import com.cledsonleite.orderservice.application.core.domain.entity.Product;
import com.cledsonleite.orderservice.application.core.domain.entity.Restaurant;

import java.util.List;

public class RestaurantBuilder {
    private Restaurant restaurant;

    public RestaurantBuilder builder(){
        restaurant = new Restaurant();
        return this;
    }

    public RestaurantBuilder addProducts(List<Product> products){
        restaurant.setProducts(products);
        return this;
    }

    public RestaurantBuilder addActive(boolean isActivate){
        restaurant.setActive(isActivate);
        return this;
    }

    public Restaurant build(){
        return restaurant;
    }
}

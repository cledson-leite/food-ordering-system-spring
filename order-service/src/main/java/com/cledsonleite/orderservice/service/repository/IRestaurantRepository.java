package com.cledsonleite.orderservice.service.repository;

import com.cledsonleite.orderservice.core.domain.entity.Restaurant;

import java.util.Optional;

public interface IRestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}

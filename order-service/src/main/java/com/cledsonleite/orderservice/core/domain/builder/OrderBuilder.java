package com.cledsonleite.orderservice.core.domain.builder;

import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.entity.OrderItem;
import com.cledsonleite.orderservice.application.core.domain.valueObject.*;
import com.cledsonleite.orderservice.core.domain.valueObject.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class OrderBuilder {
    private Order order;

    public OrderBuilder builder(){
        order = new Order();
        return this;
    }

    public OrderBuilder addCustomerId(){
        CustomerId id = new CustomerId(UUID.randomUUID());
        order.setCustomerId(id);
        return this;
    }

    public OrderBuilder addRestaurantId(){
        RestaurantId id = new RestaurantId(UUID.randomUUID());
        order.setRestaurantId(id);
        return this;
    }

    public OrderBuilder addTrackingId(){
        TrackingId id = new TrackingId(UUID.randomUUID());
        order.setTrackingId(id);
        return this;
    }

    public OrderBuilder addDeliveryAddress(DeliveryAddress value){
        order.setDeliveryAddress(value);
        return this;
    }

    public OrderBuilder addProduct(BigDecimal value){
        Money price = new Money(value);
        order.setPrice(price);
        return this;
    }

    public OrderBuilder addItems(List<OrderItem> value){
        order.setItems(value);
        return this;
    }

    public OrderBuilder addStatus(OrderStatus value){
        order.setStatus(value);
        return this;
    }

    public OrderBuilder addFailureMessages(List<String> value){
        order.setFailureMessages(value);
        return this;
    }

    public Order build(){
        return order;
    }
}

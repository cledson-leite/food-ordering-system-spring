package com.cledsonleite.orderservice.core.domain.builder;

import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.entity.OrderItem;
import com.cledsonleite.orderservice.core.domain.valueObject.*;

import java.math.BigDecimal;
import java.util.List;

public class OrderBuilder {
    private Order order;

    public OrderBuilder builder(){
        order = new Order();
        return this;
    }

    public OrderBuilder addCustomerId( CustomerId id){
        order.setCustomerId(id);
        return this;
    }

    public OrderBuilder addRestaurantId(RestaurantId id){
        order.setRestaurantId(id);
        return this;
    }

    public OrderBuilder addTrackingId(TrackingId id){
        order.setTrackingId(id);
        return this;
    }

    public OrderBuilder addDeliveryAddress(DeliveryAddress value){
        order.setDeliveryAddress(value);
        return this;
    }

    public OrderBuilder addPrice(BigDecimal value){
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

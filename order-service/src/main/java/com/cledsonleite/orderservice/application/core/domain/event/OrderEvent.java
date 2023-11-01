package com.cledsonleite.orderservice.application.core.domain.event;


import com.cledsonleite.orderservice.application.core.domain.entity.Order;

import java.time.ZonedDateTime;

public abstract class OrderEvent implements IDomainEvent {
    private final Order order;
    private final ZonedDateTime createdAt;

    protected OrderEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}

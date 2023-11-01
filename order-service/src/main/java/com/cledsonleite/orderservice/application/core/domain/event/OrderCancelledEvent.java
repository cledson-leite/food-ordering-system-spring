package com.cledsonleite.orderservice.application.core.domain.event;

import com.cledsonleite.orderservice.application.core.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent{
    protected OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}

package com.cledsonleite.orderservice.core.domain.event;

import com.cledsonleite.orderservice.core.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCreateEvent extends OrderEvent{
    public OrderCreateEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}

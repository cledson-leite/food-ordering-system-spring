package com.cledsonleite.orderservice.core.useCase;

import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.entity.Restaurant;
import com.cledsonleite.orderservice.core.domain.event.OrderCancelledEvent;
import com.cledsonleite.orderservice.core.domain.event.OrderCreateEvent;
import com.cledsonleite.orderservice.core.domain.event.OrderPaidEvent;

import java.util.List;

public interface IDomainService {
    OrderCreateEvent validateAndInitiateOrder(Order order, Restaurant restaurant);
    OrderPaidEvent payOrder(Order order);
    void approveOrder(Order order);
    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);
    void cancelOrder(Order order, List<String> failureMessages);
}

package com.cledsonleite.orderservice.service.output.publisher;

import com.cledsonleite.orderservice.core.domain.event.IDomainEventPublisher;
import com.cledsonleite.orderservice.core.domain.event.OrderPaidEvent;

public interface IOrderPaidRestaurantRequestMessagePublisher
        extends IDomainEventPublisher<OrderPaidEvent> {
}

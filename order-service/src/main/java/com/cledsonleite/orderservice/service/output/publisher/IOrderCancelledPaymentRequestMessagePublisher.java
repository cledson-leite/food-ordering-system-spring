package com.cledsonleite.orderservice.service.output.publisher;

import com.cledsonleite.orderservice.core.domain.event.IDomainEventPublisher;
import com.cledsonleite.orderservice.core.domain.event.OrderCancelledEvent;

public interface IOrderCancelledPaymentRequestMessagePublisher
        extends IDomainEventPublisher<OrderCancelledEvent> {
}

package com.cledsonleite.orderservice.service.output.publisher;

import com.cledsonleite.orderservice.core.domain.event.IDomainEventPublisher;
import com.cledsonleite.orderservice.core.domain.event.OrderCreateEvent;

public interface IOrderCreatePaymentRequestMessagePublisher
        extends IDomainEventPublisher<OrderCreateEvent> {
}

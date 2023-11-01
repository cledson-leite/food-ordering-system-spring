package com.cledsonleite.orderservice.core.domain.event;

public interface IDomainEventPublisher<T extends IDomainEvent> {
    void publish(T event);
}

package com.cledsonleite.orderservice.application.core.domain.event;

public interface IDomainEventPublisher<T extends IDomainEvent> {
    void publish(T event);
}

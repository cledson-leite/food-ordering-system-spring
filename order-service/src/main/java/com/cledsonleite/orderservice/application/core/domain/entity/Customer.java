package com.cledsonleite.orderservice.application.core.domain.entity;

import com.cledsonleite.orderservice.application.core.domain.valueObject.CustomerId;

import java.util.UUID;

public class Customer extends AggregateRoot<CustomerId> {
    public Customer() {
        super(new CustomerId(UUID.randomUUID()));
    }
}

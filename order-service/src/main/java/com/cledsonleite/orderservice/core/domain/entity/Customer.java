package com.cledsonleite.orderservice.core.domain.entity;

import com.cledsonleite.orderservice.core.domain.valueObject.CustomerId;

import java.util.UUID;

public class Customer extends AggregateRoot<CustomerId> {
    public Customer() {
        super(new CustomerId(UUID.randomUUID()));
    }
}

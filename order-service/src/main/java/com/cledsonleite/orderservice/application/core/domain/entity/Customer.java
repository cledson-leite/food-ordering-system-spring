package com.cledsonleite.orderservice.application.core.domain.entity;

import com.cledsonleite.orderservice.application.core.domain.valueObject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {
    protected Customer(CustomerId id) {
        super(id);
    }
}

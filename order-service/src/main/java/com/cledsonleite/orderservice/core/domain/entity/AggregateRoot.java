package com.cledsonleite.orderservice.core.domain.entity;

import com.cledsonleite.orderservice.core.domain.valueObject.BaseId;

public abstract class AggregateRoot<ID> extends BaseId<ID> {
    protected AggregateRoot(ID value) {
        super(value);
    }
}

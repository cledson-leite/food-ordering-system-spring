package com.cledsonleite.orderservice.application.core.domain.entity;

import com.cledsonleite.orderservice.application.core.domain.valueObject.BaseId;

public abstract class AggregateRoot<ID> extends BaseId<ID> {
    protected AggregateRoot(ID value) {
        super(value);
    }
}

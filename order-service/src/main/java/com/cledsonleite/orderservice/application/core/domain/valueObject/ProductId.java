package com.cledsonleite.orderservice.application.core.domain.valueObject;

import java.util.UUID;

public class ProductId extends BaseId<UUID> {
    public ProductId(UUID value) {
        super(value);
    }
}

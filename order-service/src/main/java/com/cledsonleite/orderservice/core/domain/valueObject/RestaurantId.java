package com.cledsonleite.orderservice.core.domain.valueObject;

import java.util.UUID;

public class RestaurantId extends BaseId<UUID>{
    public RestaurantId(UUID value) {
        super(value);
    }
}

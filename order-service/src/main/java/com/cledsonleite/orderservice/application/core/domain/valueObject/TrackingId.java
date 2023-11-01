package com.cledsonleite.orderservice.application.core.domain.valueObject;

import java.util.UUID;

public class TrackingId extends BaseId<UUID>{
    public TrackingId(UUID value) {
        super(value);
    }
}

package com.cledsonleite.orderservice.service.dto.track;

import com.cledsonleite.orderservice.core.domain.valueObject.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TrackOrderResponse {
    @NotNull
    private final UUID trackingId;
    @NotNull
    private final OrderStatus status;
    private  final List<String> failureMessages;
}

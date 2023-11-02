package com.cledsonleite.orderservice.config.kafka;

import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.event.OrderEvent;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class Message {
    private Order order;
    private OrderEvent event;
}

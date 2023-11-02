package com.cledsonleite.orderservice.service.output.repository;

import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.valueObject.TrackingId;

import java.util.Optional;

public interface IOrderRepository {
    Order save(Order order);
    Optional<Order> findByTrackingId(TrackingId trackingId);
}

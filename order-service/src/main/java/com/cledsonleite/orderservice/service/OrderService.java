package com.cledsonleite.orderservice.service;

import com.cledsonleite.orderservice.service.dto.create.CreateOrderCommand;
import com.cledsonleite.orderservice.service.dto.create.CreateOrderResponse;
import com.cledsonleite.orderservice.service.dto.track.TrackOrderQuery;
import com.cledsonleite.orderservice.service.dto.track.TrackOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderCreateCommandHandler orderCreate;

    @Autowired
    private OrderTrackCommandHandler orderTrack;

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand command) {
        return orderCreate.createOrder(command);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery query) {
        return orderTrack.trackOrder(query);
    }
}

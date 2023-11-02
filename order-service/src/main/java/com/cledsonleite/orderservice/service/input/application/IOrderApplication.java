package com.cledsonleite.orderservice.service.input.application;

import com.cledsonleite.orderservice.service.dto.create.CreateOrderCommand;
import com.cledsonleite.orderservice.service.dto.create.CreateOrderResponse;
import com.cledsonleite.orderservice.service.dto.track.TrackOrderQuery;
import com.cledsonleite.orderservice.service.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface IOrderApplication {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand command);
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery query);
}

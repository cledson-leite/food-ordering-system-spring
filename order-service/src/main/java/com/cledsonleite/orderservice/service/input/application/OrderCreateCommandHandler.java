package com.cledsonleite.orderservice.service.input.application;

import com.cledsonleite.orderservice.core.domain.event.OrderCreateEvent;
import com.cledsonleite.orderservice.service.dto.create.CreateOrderCommand;
import com.cledsonleite.orderservice.service.dto.create.CreateOrderResponse;
import com.cledsonleite.orderservice.service.mapper.OrderDataMapper;
import com.cledsonleite.orderservice.service.output.publisher.IOrderCreatePaymentRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    @Autowired
    private IOrderCreatePaymentRequestMessagePublisher publisher;

    @Autowired
    private OrderCreateHelper helper;

    @Autowired
    private OrderDataMapper mapper;


    public CreateOrderResponse createOrder(CreateOrderCommand command) {
        OrderCreateEvent event = helper.persistOrder(command);
        publisher.publish(event);
        return mapper.toCreateOrderResponse(event.getOrder());
    }
}

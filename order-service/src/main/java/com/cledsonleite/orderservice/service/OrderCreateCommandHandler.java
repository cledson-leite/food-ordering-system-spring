package com.cledsonleite.orderservice.service;

import com.cledsonleite.orderservice.core.domain.entity.Customer;
import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.entity.Restaurant;
import com.cledsonleite.orderservice.core.domain.event.OrderCreateEvent;
import com.cledsonleite.orderservice.core.domain.exception.OrderDomainException;
import com.cledsonleite.orderservice.core.useCase.IDomainService;
import com.cledsonleite.orderservice.service.dto.create.CreateOrderCommand;
import com.cledsonleite.orderservice.service.dto.create.CreateOrderResponse;
import com.cledsonleite.orderservice.service.mapper.OrderDataMapper;
import com.cledsonleite.orderservice.service.publisher.IOrderCreatePaymentRequestMessagePublisher;
import com.cledsonleite.orderservice.service.repository.ICustomerRepository;
import com.cledsonleite.orderservice.service.repository.IOrderRepository;
import com.cledsonleite.orderservice.service.repository.IRestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

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

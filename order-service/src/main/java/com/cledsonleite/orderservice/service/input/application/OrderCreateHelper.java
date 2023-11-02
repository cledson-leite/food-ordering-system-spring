package com.cledsonleite.orderservice.service.input.application;

import com.cledsonleite.orderservice.core.domain.entity.Customer;
import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.entity.Restaurant;
import com.cledsonleite.orderservice.core.domain.event.OrderCreateEvent;
import com.cledsonleite.orderservice.core.domain.exception.OrderDomainException;
import com.cledsonleite.orderservice.core.useCase.IDomainService;
import com.cledsonleite.orderservice.service.dto.create.CreateOrderCommand;
import com.cledsonleite.orderservice.service.mapper.OrderDataMapper;
import com.cledsonleite.orderservice.service.output.repository.ICustomerRepository;
import com.cledsonleite.orderservice.service.output.repository.IOrderRepository;
import com.cledsonleite.orderservice.service.output.repository.IRestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateHelper {
    @Autowired
    private IDomainService useCase;

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Autowired
    private OrderDataMapper mapper;
    @Transactional
    public OrderCreateEvent persistOrder(CreateOrderCommand command){
        checkCustomer(command.getCustomerId());
        Restaurant restaurant = checkRestaurant(command);
        Order order = mapper.toOrder(command);
        Order orderResponse = saveOrder(order);
        log.info("Pedido com id { } criado com sucesso!", orderResponse.getId().getId());
        return useCase.validateAndInitiateOrder(order, restaurant);
    }
    private Order saveOrder(Order order) {
        Order orderResponse = orderRepository.save(order);
        if (orderResponse == null){
            log.error("Pedido não pode ser salvo!");
            throw  new OrderDomainException("Pedido não pode ser salvo!");
        }
        log.info("Pedido salvo com id { }", orderResponse.getId().getId());
        return orderResponse;
    }
    private Restaurant checkRestaurant(CreateOrderCommand command) {
        Restaurant restaurant = mapper.toRestaurant(command);
        Optional<Restaurant> optionalRestaurant = restaurantRepository
                .findRestaurantInformation(restaurant);
        if (optionalRestaurant.isEmpty()) {
            log.warn("Restaurante com id { } não encontrado", restaurant.getId().getId());
            throw new OrderDomainException(
                    String.format(
                            "Restaurante com id { } não encontrado", restaurant.getId().getId()
                    )
            );
        }
        return optionalRestaurant.get();
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            log.warn("Cliente com id { } não encontrado", customerId);
            throw new OrderDomainException(
                    String.format(
                            "Cliente com id { } não encontrado", customerId
                    )
            );
        }
    }
}

package com.cledsonleite.orderservice.core.useCase;

import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.entity.Product;
import com.cledsonleite.orderservice.core.domain.entity.Restaurant;
import com.cledsonleite.orderservice.core.domain.event.OrderCancelledEvent;
import com.cledsonleite.orderservice.core.domain.event.OrderCreateEvent;
import com.cledsonleite.orderservice.core.domain.event.OrderPaidEvent;
import com.cledsonleite.orderservice.core.domain.exception.OrderDomainException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class DomainService implements IDomainService{
    @Override
    public OrderCreateEvent validateAndInitiateOrder(Order order, Restaurant restaurant) {
        validateRestaurant(restaurant);
        setOrderProductInformation(order, restaurant);
        order.validateOrder();
        order.initializeOrder();
        return new OrderCreateEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    private void setOrderProductInformation(Order order, Restaurant restaurant) {
        order.getItems().forEach(
                orderItem -> restaurant.getProducts().forEach(
                       product -> {
                           Product current = orderItem.getProduct();
                           if (current.equals(product)){
                               current.updateWithConfirmedNameAndPrice(
                                       product.getName(), product.getPrice()
                               );
                           }
                       }
                )
        );
    }

    private void validateRestaurant(Restaurant restaurant) {
        if (!restaurant.isActive()){
            throw  new OrderDomainException(
                    String.format(
                            "Restaurante com id { } não esta ativo neste momento!",
                            restaurant.getId().getId()
                    )
            );
        }
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
    }
}

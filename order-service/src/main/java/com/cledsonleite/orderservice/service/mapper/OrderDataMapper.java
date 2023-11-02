package com.cledsonleite.orderservice.service.mapper;

import com.cledsonleite.orderservice.core.domain.builder.OrderBuilder;
import com.cledsonleite.orderservice.core.domain.builder.OrderItemBuilder;
import com.cledsonleite.orderservice.core.domain.builder.RestaurantBuilder;
import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.entity.OrderItem;
import com.cledsonleite.orderservice.core.domain.entity.Product;
import com.cledsonleite.orderservice.core.domain.entity.Restaurant;
import com.cledsonleite.orderservice.core.domain.valueObject.CustomerId;
import com.cledsonleite.orderservice.core.domain.valueObject.DeliveryAddress;
import com.cledsonleite.orderservice.core.domain.valueObject.ProductId;
import com.cledsonleite.orderservice.core.domain.valueObject.RestaurantId;
import com.cledsonleite.orderservice.service.dto.create.CreateOrderCommand;
import com.cledsonleite.orderservice.service.dto.create.CreateOrderResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {
    public Restaurant toRestaurant(CreateOrderCommand command) {
        return new RestaurantBuilder()
                .addProducts(
                        command.getItems().stream().map(
                                item -> new Product(new ProductId(item.getProductId()))
                        ).collect(Collectors.toList())
                )
                .build();
    }

    public Order toOrder(CreateOrderCommand command) {
        OrderBuilder builder = new OrderBuilder();
        return builder
                .builder()
                .addCustomerId(
                        new CustomerId(command.getCustomerId())
                )
                .addRestaurantId(
                        new RestaurantId(command.getRestaurantId())
                )
                .addPrice(command.getPrice())
                .addDeliveryAddress(
                        new DeliveryAddress(
                                UUID.randomUUID(),
                                command.getAddress().getStreet(),
                                command.getAddress().getPostalCode(),
                                command.getAddress().getCity()
                        )
                )
                .addItems(toOrderItems(command.getItems()))
                .build();
    }

    private List<OrderItem> toOrderItems(List<com.cledsonleite.orderservice.service.dto.create.OrderItem> items) {
        OrderItemBuilder builder = new OrderItemBuilder();
        return items.stream().map(
                item -> builder
                        .builder()
                        .addOrderId()
                        .addProduct(
                                new Product(
                                        new ProductId(item.getProductId()
                                        )
                                )
                        )
                        .addPrice(item.getPrice())
                        .build()
        ).collect(Collectors.toList());
    }

    public CreateOrderResponse toCreateOrderResponse(Order order){
        return CreateOrderResponse
                .builder()
                .trackingId(order.getTrackingId().getId())
                .status(order.getStatus())
                .build();
    }
}

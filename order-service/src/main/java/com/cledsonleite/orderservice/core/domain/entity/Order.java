package com.cledsonleite.orderservice.core.domain.entity;

import com.cledsonleite.orderservice.core.domain.exception.OrderDomainException;
import com.cledsonleite.orderservice.application.core.domain.valueObject.*;
import com.cledsonleite.orderservice.core.domain.valueObject.*;

import java.util.List;
import java.util.UUID;


public class Order extends AggregateRoot<OrderId> {
    private CustomerId customerId;
    private RestaurantId restaurantId;
    private DeliveryAddress deliveryAddress;
    private Money price;
    private List<OrderItem> items;
    private TrackingId trackingId;
    private OrderStatus status;
    List<String> failureMessages;

    public Order() {
        super(new OrderId(UUID.randomUUID()));
    }

    public void initializeOrder() {
        setId(new OrderId(UUID.randomUUID()));
        trackingId = new TrackingId(UUID.randomUUID());
        status = OrderStatus.PENDING;
        initializeOrderItem();
    }

    private void initializeOrderItem() {
        Long itemId = 1L;
        for (OrderItem orderItem : items) {
            orderItem.initializeOrderItem(super.getId(), new OrderItemId(itemId++));
        }

    }

    public void pay() {
        if (status != OrderStatus.PENDING) {
            throw new OrderDomainException(
                    "Pedido não estar no estado correto para operação de pagamento!"
            );
        }
        status = OrderStatus.PAID;
    }

    public void approve() {
        if (status != OrderStatus.PAID) {
            throw new OrderDomainException(
                    "Pedido não estar no estado correto para operação de aprovação!"
            );
        }
        status = OrderStatus.APPROVED;
    }

    public void initCancel(List<String> failureMessages) {
        if (status != OrderStatus.PAID) {
            throw new OrderDomainException(
                    "Pedido não estar no estado correto para iniciar operação de cancelamento!"
            );
        }
        status = OrderStatus.CANCELLING;
        updateFailureMessages(failureMessages);
    }

    public void cancel(List<String> failureMessages) {
        if (!(status == OrderStatus.CANCELLING || status == OrderStatus.PAID)) {
            throw new OrderDomainException(
                    "Pedido não estar no estado correto para operação de cancelamento!"
            );
        }
        status = OrderStatus.CANCELLED;
        updateFailureMessages(failureMessages);
    }

    private void updateFailureMessages(List<String> failureMessages) {
        if (this.failureMessages != null && failureMessages != null) {
            this.failureMessages.addAll(
                    failureMessages.stream().filter(
                            message -> !message.isEmpty()
                    ).toList()
            );
            if (this.failureMessages == null) {
                this.failureMessages = failureMessages;
            }
        }
    }

    public void validateOrder() {
        validateInitialOrder();
        validateTotalPrice();
        validateItemsPrice();
    }

    private void validateItemsPrice() {
        Money itemsTotal = items.stream().map(
                item -> {
                    validateOrderItemPrice(item);
                    return item.getSubtotal();
                }
        ).reduce(Money.ZERO, Money::add);
        if (!price.equals(itemsTotal)) {
            throw new OrderDomainException(
                    String.format(
                            "Preço total { } é igual á total de itens do pedido { }!",
                            price.getAmount(),
                            itemsTotal.getAmount()
                    )
            );
        }
    }

    private void validateOrderItemPrice(OrderItem orderItem) {
        if (!orderItem.isPriceValid()) {
            throw new OrderDomainException(
                    String.format(
                            "Preço { } do item do pedido não é valido para o produto { }",
                            orderItem.getPrice().getAmount(),
                            orderItem.getProduct().getId()
                    )
            );
        }
    }

    private void validateTotalPrice() {
        if (price != null || !price.isGreaterThanZero()) {
            throw new OrderDomainException("Preço total deve ser maior que zero!");
        }
    }

    private void validateInitialOrder() {
        if (status != null || getId() != null) {
            throw new OrderDomainException(
                    "Pedido não estar no estado correto para inicialização!"
            );
        }
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public RestaurantId getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(RestaurantId restaurantId) {
        this.restaurantId = restaurantId;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public TrackingId getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(TrackingId trackingId) {
        this.trackingId = trackingId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public void setFailureMessages(List<String> failureMessages) {
        this.failureMessages = failureMessages;
    }
}

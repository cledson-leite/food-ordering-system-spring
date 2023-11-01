package com.cledsonleite.orderservice.core.domain.builder;

import com.cledsonleite.orderservice.core.domain.entity.OrderItem;
import com.cledsonleite.orderservice.core.domain.entity.Product;
import com.cledsonleite.orderservice.core.domain.valueObject.Money;
import com.cledsonleite.orderservice.core.domain.valueObject.OrderId;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItemBuilder {
    private OrderItem item;

    public OrderItemBuilder builder(){
        item = new OrderItem();
        return this;
    }

    public OrderItemBuilder addOrderId(){
        OrderId id = new OrderId(UUID.randomUUID());
        item.setOrderId(id);
        return this;
    }

    public OrderItemBuilder addProduct(Product value){
        item.setProduct(value);
        return this;
    }

    public OrderItemBuilder addQuantity(int value){
        item.setQuantity(value);
        return this;
    }

    public OrderItemBuilder addProduct(BigDecimal value){
        Money price = new Money(value);
        item.setPrice(price);
        return this;
    }

    public OrderItemBuilder addSubtotal(BigDecimal value){
        Money subtotal = new Money(value);
        item.setSubtotal(subtotal);
        return this;
    }

    public OrderItem build(){
        return item;
    }
}

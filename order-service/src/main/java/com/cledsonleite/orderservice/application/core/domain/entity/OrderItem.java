package com.cledsonleite.orderservice.application.core.domain.entity;

import com.cledsonleite.orderservice.application.core.domain.valueObject.BaseId;
import com.cledsonleite.orderservice.application.core.domain.valueObject.Money;
import com.cledsonleite.orderservice.application.core.domain.valueObject.OrderId;
import com.cledsonleite.orderservice.application.core.domain.valueObject.OrderItemId;

import java.util.Random;
import java.util.UUID;

public class OrderItem extends BaseId<OrderItemId> {
    private  OrderId orderId;
    private  Product product;
    private  int quantity;
    private  Money price;
    private  Money subtotal;

    public OrderItem() {
        super(new OrderItemId(new Random().nextLong()));
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderId orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId){
        this.orderId = orderId;
        super.setId(orderItemId);
    }

    boolean isPriceValid(){
        return price.isGreaterThanZero()
                && price.equals(product.getPrice())
                && price.multiply(quantity).equals(subtotal);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Money getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Money subtotal) {
        this.subtotal = subtotal;
    }
}

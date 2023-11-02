package com.cledsonleite.orderservice.core.domain.entity;

import com.cledsonleite.orderservice.core.domain.valueObject.BaseId;
import com.cledsonleite.orderservice.core.domain.valueObject.Money;
import com.cledsonleite.orderservice.core.domain.valueObject.ProductId;

import java.util.UUID;

public class Product extends BaseId<ProductId> {
    private String name;
    private Money price;

    public Product(ProductId id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public void updateWithConfirmedNameAndPrice(String name, Money price){
        this.name = name;
        this.price = price;
    }
}

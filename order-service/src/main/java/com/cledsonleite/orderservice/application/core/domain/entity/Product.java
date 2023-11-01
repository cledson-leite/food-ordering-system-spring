package com.cledsonleite.orderservice.application.core.domain.entity;

import com.cledsonleite.orderservice.application.core.domain.valueObject.BaseId;
import com.cledsonleite.orderservice.application.core.domain.valueObject.Money;
import com.cledsonleite.orderservice.application.core.domain.valueObject.ProductId;

public class Product extends BaseId<ProductId> {
    private String name;
    private Money price;
    protected Product(ProductId value, String name, Money price) {
        super(value);
        this.name = name;
        this.price = price;
    }
    protected Product(ProductId value) {
        super(value);
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

package com.cledsonleite.orderservice.core.domain.valueObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;
    public static final  Money ZERO = new Money(BigDecimal.ZERO);

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isGreaterThanZero() {
        return amount != null && amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(Money money) {
        return amount != null && amount.compareTo(money.getAmount()) > 0;
    }

    public Money add(Money money) {
        return new Money(
                amount.add(money.getAmount()).setScale(2, RoundingMode.HALF_EVEN)
        );
    }

    public Money subtract(Money money) {
        return new Money(
                amount.subtract(money.getAmount()).setScale(2, RoundingMode.HALF_EVEN)
        );
    }

    public Money multiply(int multiplier) {
        return new Money(
                amount.multiply(new BigDecimal(multiplier)).setScale(2, RoundingMode.HALF_EVEN)
        );
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}

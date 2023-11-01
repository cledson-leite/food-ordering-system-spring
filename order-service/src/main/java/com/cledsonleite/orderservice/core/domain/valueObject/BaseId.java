package com.cledsonleite.orderservice.core.domain.valueObject;

import java.util.Objects;

public abstract class BaseId<T> {
    private T value;

    protected BaseId(T value) {
        this.value = value;
    }
    public T getId() {
        return value;
    }

    public void setId(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) o;
        return Objects.equals(value, baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

package com.cledsonleite.orderservice.service.repository;

import com.cledsonleite.orderservice.core.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface ICustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);
}

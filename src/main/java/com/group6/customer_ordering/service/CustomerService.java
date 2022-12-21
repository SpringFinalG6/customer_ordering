package com.group6.customer_ordering.service;

import com.group6.customer_ordering.controller.reponse.Pagination;
import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.projection.CustomerProjection;

import java.util.List;

public interface CustomerService {

    List<CustomerProjection> findAll();

    Customers findCustomerById(Long id);
    Customers createNewCustomer(Customers customer);
    Customers findByUsernameContainsIgnoreCase(String username);

    Customers updateExistingCustomer(Customers customer);

    void delete(Long id);
}

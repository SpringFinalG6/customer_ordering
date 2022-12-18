package com.group6.customer_ordering.service;

import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.payload.Pagination;

import java.util.List;

public interface CustomerService {

    List<Customers> findAll(Pagination pagination);

    List<Customers> findByUsernameContainsIgnoreCase(String username);

    Customers findCustomerById(Long id);

    Customers findByEmailIgnoreCase(String email);

    Customers createNewCustomer(Customers customer);

    Customers updateExistingCustomer(Customers customer);

    void deleteExistingCustomerById(Long id);

}

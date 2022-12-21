package com.group6.customer_ordering.repository;

import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.projection.CustomerProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
    List<Customers> findByUsernameContainsIgnoreCase(String username);

    List<CustomerProjection> findCustomerProjectionBy();

}

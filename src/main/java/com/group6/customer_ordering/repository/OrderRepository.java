package com.group6.customer_ordering.repository;

import com.group6.customer_ordering.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}

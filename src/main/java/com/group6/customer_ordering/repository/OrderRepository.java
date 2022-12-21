package com.group6.customer_ordering.repository;

import com.group6.customer_ordering.entity.Orders;
import com.group6.customer_ordering.entity.projection.OrderProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    Page<OrderProjection> findOrderProjectionByOrderByCreatedAtDesc(PageRequest of);
}

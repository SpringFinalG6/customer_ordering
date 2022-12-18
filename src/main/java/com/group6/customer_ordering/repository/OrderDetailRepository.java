package com.group6.customer_ordering.repository;

import com.group6.customer_ordering.entity.Order_detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<Order_detail, Long> {
}

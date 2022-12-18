package com.group6.customer_ordering.repository;

import com.group6.customer_ordering.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}

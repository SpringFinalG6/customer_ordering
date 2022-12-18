package com.group6.customer_ordering.repository;

import com.group6.customer_ordering.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {

}

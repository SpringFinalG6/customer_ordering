package com.group6.customer_ordering.repository;

import com.group6.customer_ordering.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customers, Long> {

}

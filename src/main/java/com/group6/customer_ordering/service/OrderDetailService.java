package com.group6.customer_ordering.service;

import com.group6.customer_ordering.entity.Order_detail;
import com.group6.customer_ordering.payload.PaginationAddRequest;

import java.util.List;

public interface OrderDetailService {

    List<Order_detail> findAll();

    Order_detail findById(Long id);

    Order_detail update(Order_detail order_detail);

    void delete(Long id);

    Order_detail add(Order_detail addOrder);
}

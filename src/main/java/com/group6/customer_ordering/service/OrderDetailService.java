package com.group6.customer_ordering.service;

import com.group6.customer_ordering.entity.Order_detail;
import com.group6.customer_ordering.payload.PaginationAddRequest;

import java.util.List;

public interface OrderDetailService {

    List<Order_detail> findAll(PaginationAddRequest pagination);

    Order_detail findOrderDetailById(Long id);

    Order_detail createNewOrderDetail(Order_detail order_detail);

    Order_detail updateById(Order_detail order_detail);

    void deleteById(Long id);

}

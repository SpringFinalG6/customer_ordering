package com.group6.customer_ordering.service;

import com.group6.customer_ordering.entity.Orders;
import com.group6.customer_ordering.payload.Pagination;

import java.util.List;

public interface OrderService {

    List<Orders> findAll(Pagination pagination);

    Orders findOrderById(Long id);

    Orders createNewOrder(Orders order);

    Orders updateById(Orders orders);

    void deleteById(Long id);

}

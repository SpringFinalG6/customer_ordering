package com.group6.customer_ordering.service;

import com.group6.customer_ordering.controller.reponse.Pagination;
import com.group6.customer_ordering.entity.Orders;
import com.group6.customer_ordering.entity.projection.OrderProjection;

import java.util.List;

public interface OrderService {

    List<OrderProjection> findAll();

    Orders findOrderById(Long id);

    Orders createNewOrder(Orders order);

    void deleteById(Long id);

    List<OrderProjection> findOrderProjectionByOrderByCreatedAtDesc(Pagination pagination);

}

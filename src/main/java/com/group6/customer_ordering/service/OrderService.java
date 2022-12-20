package com.group6.customer_ordering.service;

import com.group6.customer_ordering.controller.reponse.Pagination;
import com.group6.customer_ordering.entity.Orders;
import com.group6.customer_ordering.entity.projection.CustomerProjection;
import com.group6.customer_ordering.entity.projection.OrderProjection;
import com.group6.customer_ordering.payload.PaginationAddRequest;

import java.util.List;

public interface OrderService {

    List<Orders> findAll(PaginationAddRequest pagination);

    Orders findOrderById(Long id);

    Orders createNewOrder(Orders order);

    Orders updateById(Orders orders);

    void deleteById(Long id);

    List<OrderProjection> findOrderProjectionByOrderByCreatedAtDesc(Pagination pagination);

}

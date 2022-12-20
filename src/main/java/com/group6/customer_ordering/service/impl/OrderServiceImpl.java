package com.group6.customer_ordering.service.impl;

import com.group6.customer_ordering.controller.reponse.Pagination;
import com.group6.customer_ordering.entity.Orders;
import com.group6.customer_ordering.entity.projection.OrderProjection;
import com.group6.customer_ordering.payload.PaginationAddRequest;
import com.group6.customer_ordering.repository.OrderRepository;
import com.group6.customer_ordering.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Orders> findAll(PaginationAddRequest pagination) {
        Page<Orders> order = orderRepository.findAll(PageRequest.of(pagination.getPage(), pagination.getSize()));
        pagination.setTotalCounts(order.getTotalElements());
        return order.getContent() ;
    }

    @Override
    public Orders findOrderById(Long id) {
        return this.orderRepository.findById(id).get();
    }

    @Override
    public Orders createNewOrder(Orders order) {
        return this.orderRepository.save(order);
    }

    @Override
    public Orders updateById(Orders orders) {
        return this.orderRepository.save(orders);
    }

    @Override
    public void deleteById(Long id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public List<OrderProjection> findOrderProjectionByOrderByCreatedAtDesc
            (Pagination pagination) {
        Page<OrderProjection> orderProjection = this.orderRepository
                .findOrderProjectionByOrderByCreatedAtDesc(
                        PageRequest.of(pagination.getPage(),
                                pagination.getSize()
                        ));
        pagination.setTotalCounts(orderProjection.getTotalElements());
        return orderProjection.getContent();
    }

}

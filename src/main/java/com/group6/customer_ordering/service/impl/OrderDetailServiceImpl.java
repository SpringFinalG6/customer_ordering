package com.group6.customer_ordering.service.impl;

import com.group6.customer_ordering.entity.Order_detail;
import com.group6.customer_ordering.payload.PaginationAddRequest;
import com.group6.customer_ordering.repository.OrderDetailRepository;
import com.group6.customer_ordering.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<Order_detail> findAll() {
        return this.orderDetailRepository.findAll();
    }

    @Override
    public Order_detail findById(Long id) {
        return this.orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public Order_detail update(Order_detail order_detail) {
        return this.orderDetailRepository.save(order_detail);
    }

    @Override
    public void delete(Long id) {
        this.orderDetailRepository.deleteById(id);
    }

    @Override
    public Order_detail add(Order_detail order_detail) {
        return this.orderDetailRepository.save(order_detail);
    }

}

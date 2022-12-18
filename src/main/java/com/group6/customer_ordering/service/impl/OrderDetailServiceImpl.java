package com.group6.customer_ordering.service.impl;

import com.group6.customer_ordering.entity.Order_detail;
import com.group6.customer_ordering.payload.Pagination;
import com.group6.customer_ordering.repository.OrderDetailRepository;
import com.group6.customer_ordering.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<Order_detail> findAll(Pagination pagination) {
        Page<Order_detail> order_details = orderDetailRepository.findAll(PageRequest.of(pagination.getPage(), pagination.getSize()));
        pagination.setTotalCounts(order_details.getTotalElements());
        return order_details.getContent() ;
    }

    @Override
    public Order_detail findOrderDetailById(Long id) {
        return this.orderDetailRepository.findById(id).get();
    }

    @Override
    public Order_detail createNewOrderDetail(Order_detail order_detail) {
        return this.orderDetailRepository.save(order_detail);
    }

    @Override
    public Order_detail updateById(Order_detail order_detail) {
        return this.orderDetailRepository.save(order_detail);
    }

    @Override
    public void deleteById(Long id) {
        this.orderDetailRepository.deleteById(id);
    }

}

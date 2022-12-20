package com.group6.customer_ordering.entity.projection;

import com.group6.customer_ordering.entity.Orders;
import com.group6.customer_ordering.entity.Products;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;

public interface OrderProjection {

    Long getId();
    String getCreatedAt();

    List<OrderDetailProjection> getOrderDetailProjection();
    interface OrderDetailProjection{

        @Value("#{target.id}")
        Long getId();

        @Value("#{target.createdAt}")
        String getCreatedAt();

        @Value("#{target.product}")
        Products getProducts();

        @Value("#{target.orders}")
        Orders getOrders();

        @Value("#{target.quantity}")
        int getQuantity();

        @Value("#{target.price}")
        int getPrice();

    }

}

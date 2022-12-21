package com.group6.customer_ordering.entity.projection;

import com.group6.customer_ordering.entity.enums.Gender;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface ProductProjection {

    Long getId();
    String getName();
    String getCode();
    Gender getPrice();

    List<OrderProjection> getOrderCollection();
    interface OrderProjection{

        @Value("#{target.id}")
        Long getId();

        @Value("#{target.createdAt}")
        String getCreatedAt();

    }
}

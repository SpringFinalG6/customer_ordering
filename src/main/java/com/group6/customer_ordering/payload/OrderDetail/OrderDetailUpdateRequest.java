package com.group6.customer_ordering.payload.OrderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailUpdateRequest {

    private Long id;
    private int quantity;
    private float price;
}

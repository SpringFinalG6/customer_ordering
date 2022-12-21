package com.group6.customer_ordering.payload.OrderDetail;

import com.group6.customer_ordering.entity.Orders;
import com.group6.customer_ordering.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailAddRequest {
    private Products products;
    private Orders orders;
    private int quantity;
    private float price;

}

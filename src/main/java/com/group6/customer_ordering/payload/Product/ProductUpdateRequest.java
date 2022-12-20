package com.group6.customer_ordering.payload.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequest {

    private Long id;
    private String name;
    private String code;
    private float price;

}

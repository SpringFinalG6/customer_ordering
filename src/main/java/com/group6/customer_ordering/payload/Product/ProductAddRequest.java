package com.group6.customer_ordering.payload.Product;

import com.group6.customer_ordering.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddRequest extends BaseEntity {

    private String name;
    private String code;
    private float price;

}

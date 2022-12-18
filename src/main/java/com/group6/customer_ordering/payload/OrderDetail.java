package com.group6.customer_ordering.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class OrderDetail {

    @NotBlank
    @Size(max = 10)
    private int quantity;

    @NotBlank
    private int price;

}

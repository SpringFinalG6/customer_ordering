package com.group6.customer_ordering.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_order_detail")
@Data
public class Order_detail extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @Column(name = "quantity" , length = 10, nullable = false)
    private int quantity;

    @Column(name = "price" , length = 8, nullable = false)
    private float price;
}

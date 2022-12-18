package com.group6.customer_ordering.entity;


import javax.persistence.*;

@Entity
@Table(name = "tb_order_detail")
public class Order_detail extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products products;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Orders orders;

    @Column(name = "quantity" , length = 10, nullable = false)
    private int quantity;

    @Column(name = "price" , length = 10, nullable = false)
    private int price;
}

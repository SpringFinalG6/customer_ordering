package com.group6.customer_ordering.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Orders extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @OneToMany(mappedBy = "orders")
    Set<Order_detail> order_detailSet;

}

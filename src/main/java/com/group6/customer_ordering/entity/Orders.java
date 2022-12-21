package com.group6.customer_ordering.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import lombok.Data;


@Entity
@Data
@Table(name = "tb_order")
public class Orders extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @OneToMany(mappedBy = "orders")
    Set<Order_detail> order_detailSet;

    @Column(name = "order_date" , length = 100, nullable = false)
    private Date order_date;


}

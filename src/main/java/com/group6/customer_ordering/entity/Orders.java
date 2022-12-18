package com.group6.customer_ordering.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Orders extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    private long id;

    @OneToMany(mappedBy = "orders")
    Set<Order_detail> order_detailSet;

//    @ManyToMany
//    @JoinTable(name = "tb_order_detail",
//            joinColumns = {@JoinColumn(name = "order_id")},
//            inverseJoinColumns = {@JoinColumn(name = "product_id")}
//    )
//    private List<Products> productsList;

}

package com.group6.customer_ordering.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Products extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(insertable = false, updatable = false, nullable = false)
        private Long id;

        @Column(name = "name" , length = 30, nullable = false, unique = true)
        private String name;

        @Column(name = "code" , length = 30, nullable = false, unique = true)
        private String code;

        @OneToMany(mappedBy = "products")
        Set<Order_detail> order_detailSet;

//        @ManyToMany
//        @JoinTable(name = "tb_order_detail",
//                joinColumns = {@JoinColumn(name = "product_id")},
//                inverseJoinColumns = {@JoinColumn(name = "order_id")}
//        )
//        private List<Orders> ordersList;

}

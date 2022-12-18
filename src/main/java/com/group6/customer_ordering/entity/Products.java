package com.group6.customer_ordering.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Products extends BaseEntity {

        @Column(name = "name" , length = 30, nullable = false, unique = true)
        private String name;

        @Column(name = "code" , length = 30, nullable = false, unique = true)
        private String code;

        @OneToMany(mappedBy = "products")
        Set<Order_detail> order_detailSet;

}

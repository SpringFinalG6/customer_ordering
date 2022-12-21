package com.group6.customer_ordering.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_product")
public class Products extends BaseEntity {

        @Column(name = "name" , length = 30, nullable = false, unique = true)
        private String name;

        @Column(name = "code" , length = 30, nullable = false, unique = true)
        private String code;

        @Column(name = "price" , length = 8, nullable = false)
        private float price;

        @OneToMany(mappedBy = "products")
        Set<Order_detail> order_detailSet;

}

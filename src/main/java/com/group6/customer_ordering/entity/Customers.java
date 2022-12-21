package com.group6.customer_ordering.entity;

import com.group6.customer_ordering.entity.enums.Gender;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_customer")
public class Customers extends BaseEntity {

    @Column(name = "username" , length = 50, nullable = false)
    private String username;

    @Column(name = "phone" , length = 20, nullable = false, unique = true)
    private int phone;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "address" , length = 100, nullable = false)
    private String address;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

//    private List<Orders> ordersCollections = new ArrayList<>();
}

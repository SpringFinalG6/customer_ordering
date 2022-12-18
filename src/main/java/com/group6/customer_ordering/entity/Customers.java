package com.group6.customer_ordering.entity;

import com.group6.customer_ordering.entity.enums.Gender;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class Customers extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    private long id;

    @Column(name = "username" , length = 50, nullable = false)
    private String username;

    @Column(name = "phone" , length = 20, nullable = false, unique = true)
    private String phone;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "address" , length = 100, nullable = false)
    private String address;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}

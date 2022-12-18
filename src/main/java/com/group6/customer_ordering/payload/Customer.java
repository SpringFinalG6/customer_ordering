package com.group6.customer_ordering.payload;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Customer {

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(max = 20)
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String address;

    @NotBlank
    @Size(min = 1, max = 6)
    private String gender;

}

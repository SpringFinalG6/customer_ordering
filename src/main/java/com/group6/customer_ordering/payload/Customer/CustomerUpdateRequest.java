package com.group6.customer_ordering.payload.Customer;

import com.group6.customer_ordering.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {

    private Long id;
    private String username;
    private String phone;
    private String email;
    private String address;
    private Gender gender;

}

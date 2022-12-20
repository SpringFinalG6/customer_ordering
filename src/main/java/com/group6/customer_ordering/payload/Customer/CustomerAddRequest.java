package com.group6.customer_ordering.payload.Customer;

import com.group6.customer_ordering.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerAddRequest {

    private String username;

    private String phone;

    private String email;

    private String address;

    private Gender gender;

    private List<Long> orderIdList;

}

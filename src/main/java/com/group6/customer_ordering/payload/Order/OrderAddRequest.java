package com.group6.customer_ordering.payload.Order;

import com.group6.customer_ordering.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderAddRequest {

    private List<Long> customerIdList;
    private Date order_date;

}

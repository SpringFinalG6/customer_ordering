package com.group6.customer_ordering.entity.projection;

import com.group6.customer_ordering.entity.enums.Gender;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface CustomerProjection {

    Long getId();
    String getUsername();
    String getEmail();
    Gender getGender();

    List<ProductProjection> getBookCollections();
    interface ProductProjection{

        @Value("#{target.id}")
        Long getId();
        @Value("#{target.name}")
        String getName();

    }

}

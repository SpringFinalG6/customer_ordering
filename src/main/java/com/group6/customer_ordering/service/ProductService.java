package com.group6.customer_ordering.service;

import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.Products;
import com.group6.customer_ordering.entity.projection.ProductProjection;
import com.group6.customer_ordering.payload.PaginationAddRequest;

import java.util.List;

public interface ProductService {

    List<ProductProjection> findAll();

    Products findProductById(Long id);

    Products findByNameContainsIgnoreCase(String name);

    Products findProductByCode(String code);

    Products createNewProduct(Products products);

    Products updateExistingProduct(Products products);

    void deleteExistingProductById(Long id);

}

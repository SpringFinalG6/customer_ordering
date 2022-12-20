package com.group6.customer_ordering.service;

import com.group6.customer_ordering.entity.Products;
import com.group6.customer_ordering.payload.PaginationAddRequest;

import java.util.List;

public interface ProductService {

    List<Products> findAll(PaginationAddRequest pagination);

    Products findProductById(Long id);

    Products createNewProduct(Products products);

    Products updateById(Products products);

    void deleteExistingProductById(Long id);

}

package com.group6.customer_ordering.service;

import com.group6.customer_ordering.entity.Products;
import com.group6.customer_ordering.payload.Pagination;

import java.util.List;

public interface ProductService {

    List<Products> findAll(Pagination pagination);

    List<Products> findNameContainIgnoreCase(String name);

    Products findProductById(Long id);

    Products createNewProduct(Products products);

    Products updateById(Products products);

    void deleteExistingProductById(Long id);

}

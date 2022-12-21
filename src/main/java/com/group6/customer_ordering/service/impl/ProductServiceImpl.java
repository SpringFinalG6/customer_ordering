package com.group6.customer_ordering.service.impl;


import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.Products;
import com.group6.customer_ordering.entity.projection.ProductProjection;
import com.group6.customer_ordering.repository.ProductRepository;
import com.group6.customer_ordering.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductProjection> findAll() {
        return this.productRepository.findProductProjectionBy();
    }

    @Override
    public Products findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Products findByNameContainsIgnoreCase(String name) {
        return (Products) productRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public Products createNewProduct(Products products) {

        return this.productRepository.save(products);
    }

    @Override
    public Products updateExistingProduct(Products products) {

        return productRepository.save(products);
    }

    @Override
    public void deleteExistingProductById(Long id) {
        this.productRepository.deleteById(id);
    }

}

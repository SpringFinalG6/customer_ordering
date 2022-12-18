package com.group6.customer_ordering.service.impl;


import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.Products;
import com.group6.customer_ordering.payload.Pagination;
import com.group6.customer_ordering.repository.ProductRepository;
import com.group6.customer_ordering.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public List<Products> findAll(Pagination pagination) {
        Page<Products> product = productRepository.findAll(PageRequest.of(pagination.getPage(), pagination.getSize()));
        pagination.setTotalCounts(product.getTotalElements());
        return product.getContent() ;
    }

    @Override
    public Products findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Products createNewProduct(Products products) {
        return this.productRepository.save(products);
    }

    @Override
    public Products updateById(Products products) {
        return this.productRepository.save(products);
    }

    @Override
    public void deleteExistingProductById(Long id) {
        this.productRepository.deleteById(id);
    }

}

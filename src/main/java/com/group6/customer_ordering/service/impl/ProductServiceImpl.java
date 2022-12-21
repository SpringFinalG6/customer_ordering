package com.group6.customer_ordering.service.impl;


import com.group6.customer_ordering.controller.reponse.Pagination;
import com.group6.customer_ordering.entity.Products;
import com.group6.customer_ordering.entity.projection.ProductProjection;
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
    public List<ProductProjection> findAll() {
        return this.productRepository.findProductProjectionBy();
    }

    @Override
    public Products findProductById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public Products findByNameContainsIgnoreCase(String name) {
        return this.productRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<ProductProjection> findProductProjectionByOrderByCreatedAtDesc(Pagination pagination) {
        Page<ProductProjection> userProjection = this.productRepository
                .findProductProjectionByOrderByCreatedAtDesc(
                        PageRequest.of(pagination.getPage(),
                                pagination.getSize()
                        ));
        pagination.setTotalCounts(userProjection.getTotalElements());
        return userProjection.getContent();
    }

    @Override
    public Products findProductByCode(String code) {
        return this.productRepository.findProductByCode(code);
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

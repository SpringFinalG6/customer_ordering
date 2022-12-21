package com.group6.customer_ordering.repository;

import com.group6.customer_ordering.entity.Products;
import com.group6.customer_ordering.entity.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products, Long> {

    List<Products> findByNameContainsIgnoreCase(String name);

    Optional<Products> findByCode(String code);

    List<ProductProjection> findProductProjectionBy();

    Page<ProductProjection> findProductProjectionByOrderByCreatedAtDesc(PageRequest of);
}

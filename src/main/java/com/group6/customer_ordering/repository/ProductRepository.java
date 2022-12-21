package com.group6.customer_ordering.repository;

import com.group6.customer_ordering.entity.Products;
import com.group6.customer_ordering.entity.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    Products findByNameContainsIgnoreCase(String name);

    Products findProductByCode(String code);

    List<ProductProjection> findProductProjectionBy();

    Page<ProductProjection> findProductProjectionByOrderByCreatedAtDesc(Pageable pageable);
}

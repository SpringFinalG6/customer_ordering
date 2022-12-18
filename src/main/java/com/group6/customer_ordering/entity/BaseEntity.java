package com.group6.customer_ordering.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "created_by", length = 50, updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", length = 100)
    @LastModifiedBy
    private String updatedBy;

}

package com.group6.customer_ordering.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "created_at", length = 50, columnDefinition = "TIMESTAMP")
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "created_by", length = 50)
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    @CreationTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", length = 100)
    @LastModifiedBy
    private String updatedBy;

}

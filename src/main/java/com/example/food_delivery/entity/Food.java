package com.example.food_delivery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String description;

  //  @Type(StringArrayType.class)
    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "ingredients", columnDefinition = "text[]")
    private String[] ingredients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private Integer createdBy;
    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime createdAt;
    @LastModifiedBy
    private Integer updatedBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "java_product_01")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private BigDecimal productPrice;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "java_product_order_001",
               joinColumns = @JoinColumn(name = "product_id"),
               inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    List<OrderEntity> orderList;
    //get

    //set
}

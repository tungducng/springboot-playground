package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
//@Entity
@Table(name = "java_product_01")
public class ProductEntity {

    private Long id;
    private String productName;
    private BigDecimal productPrice;

    //get

    //set
}

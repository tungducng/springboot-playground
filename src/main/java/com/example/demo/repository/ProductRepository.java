package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {

    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> findAllProducts();
}

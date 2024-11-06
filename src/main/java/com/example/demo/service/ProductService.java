package com.example.demo.service;

import com.example.demo.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> findAllProducts();

}

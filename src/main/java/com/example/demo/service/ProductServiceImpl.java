package com.example.demo.service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.createProduct(product);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
       return productRepository.findAllProducts();
    }
}

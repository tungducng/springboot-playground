package com.example.demo;

import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class OrderProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void manyToManyTest() {
        ProductEntity p1 = new ProductEntity();
        ProductEntity p2 = new ProductEntity();

        OrderEntity o1 = new OrderEntity();
        OrderEntity o2 = new OrderEntity();
        OrderEntity o3 = new OrderEntity();

        p1.setProductName("p1");
        p1.setProductPrice(new BigDecimal("4.5"));
        p2.setProductName("p2");
        p2.setProductPrice(new BigDecimal("4.6"));

        o1.setUserId(1);
        o2.setUserId(2);

        p1.setOrderList(List.of(o1, o2));
        p2.setOrderList(List.of(o1, o3, o2));

        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);

        productRepository.save(p1);
        productRepository.save(p2);
    }

    @Test
    @Transactional
    void selectManytoManyTest() {
        ProductEntity p1 = productRepository.findById(1L).orElseThrow();
        System.out.println(p1);
        System.out.println(p1.getOrderList());
    }
}

package com.example.demo.entity;

import com.example.demo.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "java_feed_01")
public class FeedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}

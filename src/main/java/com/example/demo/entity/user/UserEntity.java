package com.example.demo.entity.user;

import com.example.demo.entity.CCCDEntity;
import com.example.demo.entity.FeedEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "java_user_01")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) comment 'user name'", nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(255) comment 'user email'", nullable = false, unique = true)
    private String userEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cccd_id")
    private CCCDEntity cccd;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FeedEntity> feedList;
}

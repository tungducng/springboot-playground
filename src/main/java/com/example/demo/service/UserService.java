package com.example.demo.service;

import com.example.demo.entity.user.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();

    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);
}

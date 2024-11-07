package com.example.demo.service;

import com.example.demo.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();

    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    //get all by limit offset
    Page<UserEntity> findAllUsers(Pageable pageable);

    //get search by limit offset
    Page<UserEntity> findByUserName(String userName, Pageable pageable);
}

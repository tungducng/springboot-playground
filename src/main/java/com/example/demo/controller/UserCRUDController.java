package com.example.demo.controller;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.user.UserEntity;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCRUDController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @GetMapping("/search")
    public UserEntity searchUser(@RequestParam String userName, @RequestParam String userEmail) {
        return userService.findByUserNameAndUserEmail(userName, userEmail);
    }

    @GetMapping("/getAll")
    public Page<UserEntity> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);

        return userService.findAllUsers(pageable);
    }

    @GetMapping("/searchPage")
    public Page<UserEntity> searchPageUserName(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);

        return userService.findByUserName(name, pageable);
    }
}

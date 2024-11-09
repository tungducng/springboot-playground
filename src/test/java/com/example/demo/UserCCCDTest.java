package com.example.demo;

import com.example.demo.entity.CCCDEntity;
import com.example.demo.entity.user.UserEntity;
import com.example.demo.repository.CCCDRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class UserCCCDTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    CCCDRepository cccdRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToOneTest() {
        UserEntity user= new UserEntity();
        CCCDEntity cccd = new CCCDEntity();

        user.setUserName("tung cccd");
        user.setUserEmail("tungmail@g");

        cccd.setNumberCCCD("111213133123");
        user.setCccd(cccd);


        userRepository.save(user);
    }
}

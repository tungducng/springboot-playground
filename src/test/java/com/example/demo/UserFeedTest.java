package com.example.demo;

import com.example.demo.entity.CCCDEntity;
import com.example.demo.entity.FeedEntity;
import com.example.demo.entity.user.UserEntity;
import com.example.demo.repository.CCCDRepository;
import com.example.demo.repository.FeedRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserFeedTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Autowired
    private CCCDRepository cccdRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTest() {
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();
        CCCDEntity cccd = new CCCDEntity();

        user.setUserName("tung3");
        user.setUserEmail("tungmail" + System.currentTimeMillis() + "@gmail2.com");

        cccd.setNumberCCCD("1312312414");
        user.setCccd(cccd);

        feed.setTitle("feed01");
        feed.setDescription("des1");

        user.setFeedList(List.of(feed));
        feed.setUser(user);  // Set user in feed

        userRepository.save(user);
        // No need to save feed and cccd separately; they are cascaded from user
    }
}

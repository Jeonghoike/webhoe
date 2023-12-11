package com.lec.ch05_friend;

import com.lec.ch05_friend.domain.Friend;
import com.lec.ch05_friend.repository.FriendRepository;
import com.lec.ch05_friend.service.FriendService;
import com.lec.ch05_friend.service.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    public SpringConfig(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }
    @Bean
    public FriendService friendService(){
        return new FriendServiceImpl(friendRepository);
    }
}

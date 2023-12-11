package com.lec.ch04_friend;
import com.lec.ch04_friend.repository.FriendRepository;
import com.lec.ch04_friend.repository.FriendRepositoryImpl;
import com.lec.ch04_friend.service.FriendService;
import com.lec.ch04_friend.service.FriendServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringBeanConfig {
    @Bean
    public FriendRepository friendRepository(){
        return new FriendRepositoryImpl();
    }
    @Bean
    public FriendService friendService(){
        return new FriendServiceImpl(friendRepository());
    }
}

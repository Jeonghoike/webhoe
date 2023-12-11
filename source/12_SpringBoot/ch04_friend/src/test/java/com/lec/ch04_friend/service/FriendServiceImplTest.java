package com.lec.ch04_friend.service;

import com.lec.ch04_friend.domain.Friend;
import com.lec.ch04_friend.repository.FriendRepository;
import com.lec.ch04_friend.repository.FriendRepositoryImpl;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FriendServiceImplTest {
    //private FriendRepository repository = new FriendRepositoryImpl();
    //private FriendService friendService = new FriendServiceImpl(repository);
    @Autowired
    private FriendRepository repository;
    @Autowired
    private FriendService friendService;
    @BeforeEach
    public void beforeEach(){
        repository.deleteAll();
    }
    @Test
    void 중복되지않은전화번호친구등록() {
        Friend friend = new Friend("홍길동","010-9999-9999");
        Friend friend2 = new Friend("홍길동","010-9999-8888");
        friendService.join(friend);
        friendService.join(friend2);
        List<Friend> friends = friendService.findFriends();
        Friend resultFriend = null;
        for(Friend f : friends){
            if(f.getTel().equals(friend.getTel())){
                resultFriend = f;
            }//if
        }//for
        assertThat(friend).isEqualTo(resultFriend);
        System.out.println("중복되지 않은 전화번호 친구 등록 TEST 완료");
    }

    @Test
    void 중복전화번호친구등록(){
        Friend friend1 = new Friend("홍길동", "010-9999-9999");
        Friend friend2 = new Friend("신길동", "010-9999-9999");
        friendService.join(friend1);
        try {
            friendService.join(friend2);
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 친구입니다");
            System.out.println("중복된 전화번호 등록 TEST 완료");
        }
    }
}
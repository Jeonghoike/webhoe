package com.lec.ch05_friend.repository;

import com.lec.ch05_friend.domain.Friend;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FriendRepositoryTest {
    @Autowired
    private  FriendRepository friendRepository;
    @Test
    void save와findByTel() {
        Friend friend = new Friend("홍길동", "010-8888-8888");
        friendRepository.save(friend);
        Friend resultTel = friendRepository.findByTel(friend.getTel()).get();
        Friend resultId = friendRepository.findById(resultTel.getId()).get();
        // System.out.println(resultId.equals(resultTel) ? "OK" : "FAIL");
        assertThat(resultId).isEqualTo(resultTel);
        System.out.println("save와 findByTel TEST 완료");
    }

    @Test
    void findAll() {
        Friend f1 = new Friend("홍길동", "010-1234-1234");
        Friend f2 = new Friend("홍길동", "010-5678-5678");
        friendRepository.save(f1);
        friendRepository.save(f2);
        List<Friend> friends = friendRepository.findAll(); // ctrl + alt + v (List<>)
        assertThat(friends.size()).isEqualTo(2);
        assertThat(friends.get(0).getName()).isEqualTo(f1.getName());
        assertThat(friends.get(1).getTel()).isEqualTo(f2.getTel());
        System.out.println("findAll TEST 완료");
    }

    @Test
    void findById와findByTel() {
        Friend friend = new Friend("홍길동", "010-1234-1234");
        friendRepository.save(friend);
        Friend result1 = friendRepository.findByTel(friend.getTel()).get();
        Friend result2 = friendRepository.findById(result1.getId()).get();
        assertThat(result1).isEqualTo(result2);
        System.out.println("findById와findByTel TEST 완료");
    }

    @Test
    void deleteOne() {
        Friend friend = new Friend("홍길동", "010-1234-1234");
        friendRepository.save(friend);
        Friend deleteFriend = friendRepository.findByTel(friend.getTel()).get();
        friendRepository.deleteOne(deleteFriend.getId());
        List<Friend> friends = friendRepository.findAll();
        assertThat(friends.size()).isEqualTo(0);
        System.out.println("deleteOnd TEST 완료");
    }
}
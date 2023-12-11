package com.lec.ch04_friend.repository;
import com.lec.ch04_friend.domain.Friend;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class FriendRepositoryImplTest {
    @Autowired
    private FriendRepository repository;

    @AfterEach
    public void afterEach() {
        repository.deleteAll();
    }
    @Test
    public void save(){
        Friend friend = new Friend("홍길동","010-9999-9999");
        repository.save(friend); // 변수할당 단축키 : ctrl+alt+V
        Friend friendTel = repository.findByTel("010-9999-9999").get();
        //System.out.println(friend.equals(friendTel)? "OK" : "Fail");
        assertThat(friend).isEqualTo(friendTel);
        assertThat(friend.getName()).isEqualTo(friendTel.getName());
        assertThat(friend.getTel()).isEqualTo(friendTel.getTel());
        assertThat(friend.getId()).isEqualTo(friendTel.getId());
        System.out.println("save TEST 완료");
    }
    @Test
    public void findByTel(){
        Friend friend = new Friend("신길동", "010-8888-8888");
        Friend f1 = repository.save(friend);
        Friend f2 = repository.findByTel(f1.getTel()).get();
        assertThat(f1).isEqualTo(f2);
        System.out.println("findById TEST 완료");
    }
    @Test
    public void findAll(){
        Friend f1 = new Friend("홍길동", "010-9999-9999");
        Friend f2 = new Friend("신길동", "010-8888-8888");
        repository.save(f1);
        repository.save(f2);
        List<Friend> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
        System.out.println("findAll TEST 완료");
    }
    @Test
    public  void findById(){
        Friend friend = new Friend("홍길동","010-9999-9999");
        repository.save(friend);
        Friend result = repository.findById(friend.getId()).get();
        assertThat(friend).isEqualTo(result);
        System.out.println("findById TEST 완료");
    }
}








package com.lec.ch04_friend.service;
import com.lec.ch04_friend.domain.Friend;
import com.lec.ch04_friend.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
//@Service
public class FriendServiceImpl implements FriendService{
    // 테스트 로직 생성 : ctrl + shift + t
    private FriendRepository repository;
    // @Autowired // 생성자 단축키 : alt+insert
    public FriendServiceImpl(FriendRepository repository) {
        this.repository = repository;
    }

    @Override
    public void join(Friend friend) { // 중복된 전화번호는 저장이 안 되도록
        validateDuplicateFriendTel(friend);
        repository.save(friend); // 중복된 전화번호가 아닐 때만 save
    }
    private void validateDuplicateFriendTel(Friend friend){
        Optional<Friend> result = repository.findByTel(friend.getTel());
        result.ifPresent(friend1 -> {
            // 중복된 전화번호일 경우 IllegalStateException 예외발생
            throw new IllegalStateException("이미 존재하는 친구입니다");
        });
    }

    @Override
    public Optional<Friend> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Friend> findFriends() {
        return repository.findAll();
    }
}

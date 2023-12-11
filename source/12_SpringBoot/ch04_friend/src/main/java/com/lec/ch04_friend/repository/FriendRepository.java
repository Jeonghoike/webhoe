package com.lec.ch04_friend.repository;
import com.lec.ch04_friend.domain.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendRepository {
    public Friend save(Friend friend);
    public Optional<Friend> findById(Long id);
    public Optional<Friend> findByTel(String tel);
    public List<Friend> findAll();
    public void deleteAll(); // test 로직에서 필요
}

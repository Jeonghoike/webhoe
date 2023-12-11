package com.lec.ch04_friend.service;

import com.lec.ch04_friend.domain.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendService {
    public void join(Friend friend);
    public Optional<Friend> findOne(Long id);
    public List<Friend> findFriends();
}

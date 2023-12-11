package com.lec.ch05_friend.service;
import com.lec.ch05_friend.domain.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendService {
    public int join(Friend friend);
    public Optional<Friend> findOne(long id);
    public List<Friend> findFriend();
    public int deleteOne(long id);
}

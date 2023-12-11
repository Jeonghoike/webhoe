package com.lec.ch04_friend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private Long id;
    private String name;
    private String tel;
    public Friend(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
}

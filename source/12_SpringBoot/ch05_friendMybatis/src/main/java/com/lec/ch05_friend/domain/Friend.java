package com.lec.ch05_friend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friend {
    private  long id;
    private String name;
    private String tel;

    public Friend(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
}

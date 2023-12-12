package com.lec.ch05_friend.controller;

import com.lec.ch05_friend.domain.Friend;
import com.lec.ch05_friend.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IAttribute;

import java.net.URLEncoder;

@Controller
@Slf4j
@RequestMapping("friend")
public class FriendController {
    private FriendService friendService;
    @Autowired // 생성자 주입
    public FriendController(FriendService friendService) { // 생성자단축기 alt + insert키
        this.friendService = friendService;
    }
    @GetMapping("join")
    public String join(){
        return "friend/join";
    }
    @PostMapping("join")
    public String join(Friend friend, Model model){
        try {
            friendService.join(friend);
        }catch (IllegalStateException e){
//            log.info("친구 등록 예외 메세지 : " + e.getMessage());
//            String errMsg = URLEncoder.encode(e.getMessage()); // 이미 존재하는 친구입니다 / 한글깨짐처리
//            return "redirect:join?errMsg="+errMsg;
            model.addAttribute("errMsg", e.getMessage());
            return "friend/join";
        }
        return  "forward:list";
    }
    @PostMapping("list")
    public String listPost(Model model){
        model.addAttribute("friends", friendService.findFriend());
        return "friend/list";
    }
    @GetMapping("list")
    public String listGet(Model model){
        model.addAttribute("friends", friendService.findFriend());
        return "friend/list";
    }
    @GetMapping("findOne")
    public String findOne(long id, Model model){
        model.addAttribute("friend", friendService.findOne(id).get());
        return "friend/findOne";
    }
    @GetMapping("deleteOne")
    public String deleteOne(long id, Model model){
        model.addAttribute("deleteResult", friendService.deleteOne(id));
        return "forward:list";
    }
}

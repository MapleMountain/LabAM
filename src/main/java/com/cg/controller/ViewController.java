package com.cg.controller;

import com.cg.anntaions.RequiresRole;
import com.cg.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;
import java.util.Objects;

@Controller
public class ViewController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/homepage")
    public String homepage(){
        return "homepage";
    }
    //转跳到注册页面
    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @GetMapping("/ToTCollege")
    @RequiresRole("sadmin")
    public String TCollege(){
        return "TCollege";
    }
    @GetMapping("/Report")
    public String Report(){
        return "Report";
    }
    @RequiresRole("sadmin")
    @GetMapping("/insertLab")
    public String insertLab(){
        return "addLab";
    }

    @GetMapping("/logout")
    public  String logout(@RequestHeader("token") String token, HttpSession httpSession){
        if (httpSession!=null){
            httpSession.invalidate();
        }
        //将token从redis里移除
        stringRedisTemplate.delete(token);
        return "redirect:/login";
    }

}

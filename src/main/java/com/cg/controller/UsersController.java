package com.cg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cg.anntaions.RequiresRole;
import com.cg.pojo.Users;
import com.cg.service.LabManagersService;
import com.cg.service.UsersService;
import com.cg.utils.JwtUtil;
import com.cg.utils.Result;
import com.cg.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    LabManagersService labManagersService;
    @PostMapping("doLogin")
    @ResponseBody
    public Result login(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpSession session){
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        LambdaQueryWrapper<Users> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUsername,username);
        if (!usersService.getBaseMapper().exists(wrapper)){
            return Result.error("用户名不存在");
        }
        Users user = usersService.getOne(wrapper);
        if (user.getRole().equals("common")){
            return Result.error("普通用户不能进入系统");
        }
        if (bCryptPasswordEncoder.matches(password,user.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            //把id，username,和power存储到token
            claims.put("id", user.getUserId());
            claims.put("role",user.getRole());
            claims.put("username", user.getUsername());
            String token = JwtUtil.genToken(claims);
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token,token,1, TimeUnit.DAYS);
            System.out.println(token);
            session.setAttribute("user", user);
            return Result.success(token);//登录成功
        }
        return Result.error("密码错误");//登录失败

    }
    @PostMapping("doRegiste")
    @ResponseBody
    public Result doRegiste(@RequestBody Users users){
        LambdaQueryWrapper<Users> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUsername,users.getUsername());
        System.out.println(users);
        if (usersService.exists(wrapper)) {
            return Result.error("用户已经存在");
        }
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        users.setPassword(encoder.encode(users.getPassword()));
        usersService.getBaseMapper().insert(users);
        return Result.success("注册成功");
    }
    @GetMapping("UserManager/{id}")
    public String PostDetail(@PathVariable("id") Integer id, Model model) {
        Users one = usersService.getOne(id);
        model.addAttribute("user",one);
        return "userDetails";
    }

    @RequiresRole("sadmin")
    @GetMapping("userList")
    public String userList(Model model){
            List<Users> list = usersService.userList();
            model.addAttribute("list", list);
            return "Tuser";
    }
    @DeleteMapping("deleteUser")
    @RequiresRole("sadmin")
    @ResponseBody
    public Result deleteUser(Integer id){
        usersService.removeUserAndManager(id);//删除用户和实验室管理员
        return Result.success();
    }

}

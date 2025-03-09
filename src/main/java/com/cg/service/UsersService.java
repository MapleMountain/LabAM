package com.cg.service;

import com.cg.pojo.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【users】的数据库操作Service
* @createDate 2024-06-17 14:58:31
*/
public interface UsersService extends IService<Users> {

    void auth(Integer uid);

    void unauth(Integer uid);

    List<Users> userList();

    void removeUserAndManager(Integer id);

    Users getOne(Integer id);
}

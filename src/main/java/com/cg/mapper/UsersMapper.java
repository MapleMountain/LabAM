package com.cg.mapper;

import com.cg.pojo.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-06-17 14:58:31
* @Entity com.cg.pojo.Users
*/
public interface UsersMapper extends BaseMapper<Users> {

    List<Users> userList();

    Users getOne(Integer id);
}





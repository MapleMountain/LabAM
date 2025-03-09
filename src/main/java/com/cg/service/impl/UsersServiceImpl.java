package com.cg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cg.mapper.LabManagersMapper;
import com.cg.mapper.LaboratoriesMapper;
import com.cg.pojo.LabManagers;
import com.cg.pojo.Users;
import com.cg.service.UsersService;
import com.cg.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-06-17 14:58:31
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    LabManagersMapper labManagersMapper;
    @Autowired
    LaboratoriesMapper laboratoriesMapper;
    @Override
    public void auth(Integer uid) {
        LambdaUpdateWrapper<Users> wrapper =new LambdaUpdateWrapper<>();
        wrapper.eq(Users::getUserId,uid).set(Users::getRole,"ladmin");
        usersMapper.update(wrapper);
        laboratoriesMapper.updateLab();
    }

    @Override
    public void unauth(Integer uid) {
        LambdaQueryWrapper<LabManagers> wrapper2 =new LambdaQueryWrapper<>();
        wrapper2.eq(LabManagers::getManagerId,uid);
        labManagersMapper.delete(wrapper2);
        LambdaUpdateWrapper<Users> wrapper =new LambdaUpdateWrapper<>();
        wrapper.eq(Users::getUserId,uid).set(Users::getRole,"common");
        usersMapper.update(wrapper);
        laboratoriesMapper.updateLab();
    }

    @Override
    public List<Users> userList() {
        return usersMapper.userList();
    }

    @Override
    public void removeUserAndManager(Integer id) {
        usersMapper.deleteById(id);
        LambdaQueryWrapper<LabManagers> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(LabManagers::getManagerId,id);
        labManagersMapper.delete(wrapper);
        laboratoriesMapper.updateLab();

    }

    @Override
    public Users getOne(Integer id) {
        return usersMapper.getOne(id);
    }

}





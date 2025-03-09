package com.cg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cg.mapper.LaboratoriesMapper;
import com.cg.pojo.LabManagers;
import com.cg.service.LabManagersService;
import com.cg.mapper.LabManagersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【lab_managers】的数据库操作Service实现
* @createDate 2024-06-17 14:58:31
*/
@Service
public class LabManagersServiceImpl extends ServiceImpl<LabManagersMapper, LabManagers>
    implements LabManagersService{

@Autowired
LabManagersMapper labManagersMapper;
@Autowired
    LaboratoriesMapper laboratoriesMapper;
    @Override
    public void assign(Integer managerId, Integer labId) {
        LabManagers labManagers =new LabManagers(managerId,labId);
        labManagersMapper.insert(labManagers);
        laboratoriesMapper.updateLab();
    }

    @Override
    public void unAssign(Integer id) {
        LambdaQueryWrapper<LabManagers> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(LabManagers::getId,id);
        labManagersMapper.delete(wrapper);
        laboratoriesMapper.updateLab();
    }

    @Override
    public List<LabManagers> getManagers(Integer uid) {
        return labManagersMapper.getManagers(uid);
    }
}





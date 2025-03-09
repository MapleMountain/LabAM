package com.cg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cg.pojo.Laboratories;
import com.cg.service.LaboratoriesService;
import com.cg.mapper.LaboratoriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【laboratories】的数据库操作Service实现
* @createDate 2024-06-17 14:58:31
*/
@Service
public class LaboratoriesServiceImpl extends ServiceImpl<LaboratoriesMapper, Laboratories>
    implements LaboratoriesService{
    @Autowired
    LaboratoriesMapper laboratoriesMapper;
    @Override
    public List<Laboratories> getLabList() {
        return laboratoriesMapper.getLabList();
    }
}





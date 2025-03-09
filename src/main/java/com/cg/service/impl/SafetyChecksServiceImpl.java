package com.cg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cg.pojo.SafetyChecks;
import com.cg.service.SafetyChecksService;
import com.cg.mapper.SafetyChecksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【safety_checks】的数据库操作Service实现
* @createDate 2024-06-17 14:58:31
*/
@Service
public class SafetyChecksServiceImpl extends ServiceImpl<SafetyChecksMapper, SafetyChecks>
    implements SafetyChecksService{
    @Autowired
    SafetyChecksMapper safetyChecksMapper;
    @Override
    public List<SafetyChecks> getlist() {
        return safetyChecksMapper.getlist();

    }
}





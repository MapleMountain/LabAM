package com.cg.service;

import com.cg.pojo.SafetyChecks;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【safety_checks】的数据库操作Service
* @createDate 2024-06-17 14:58:31
*/
public interface SafetyChecksService extends IService<SafetyChecks> {

    List<SafetyChecks> getlist();
}

package com.cg.mapper;

import com.cg.pojo.SafetyChecks;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【safety_checks】的数据库操作Mapper
* @createDate 2024-06-17 14:58:31
* @Entity com.cg.pojo.SafetyChecks
*/
public interface SafetyChecksMapper extends BaseMapper<SafetyChecks> {

    List<SafetyChecks> getlist();
}





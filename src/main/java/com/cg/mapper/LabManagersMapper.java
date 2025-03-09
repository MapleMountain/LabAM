package com.cg.mapper;

import com.cg.pojo.LabManagers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【lab_managers】的数据库操作Mapper
* @createDate 2024-06-17 14:58:31
* @Entity com.cg.pojo.LabManagers
*/
public interface LabManagersMapper extends BaseMapper<LabManagers> {

    List<LabManagers> getManagers(Integer uid);
}





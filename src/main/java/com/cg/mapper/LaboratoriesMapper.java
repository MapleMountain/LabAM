package com.cg.mapper;

import com.cg.pojo.Laboratories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【laboratories】的数据库操作Mapper
* @createDate 2024-06-17 14:58:31
* @Entity com.cg.pojo.Laboratories
*/
public interface LaboratoriesMapper extends BaseMapper<Laboratories> {

    List<Laboratories> getLabList();
    @Update("UPDATE laboratories l " +
            "SET l.status = " +
            "    CASE " +
            "        WHEN EXISTS (SELECT 1 FROM lab_managers lm WHERE lm.lab_id = l.lab_id) " +
            "        THEN '已分配' " +
            "        ELSE '未分配' " +
            "    END")
    void updateLab();
}





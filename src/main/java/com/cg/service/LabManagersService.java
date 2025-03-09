package com.cg.service;

import com.cg.pojo.LabManagers;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【lab_managers】的数据库操作Service
* @createDate 2024-06-17 14:58:31
*/
public interface LabManagersService extends IService<LabManagers> {

    void assign(Integer managerId,Integer labId);

    void unAssign(Integer id);

    List<LabManagers> getManagers(Integer uid);
}

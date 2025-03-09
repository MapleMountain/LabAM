package com.cg.service;

import com.cg.pojo.Laboratories;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author MIZUGI
* @description 针对表【laboratories】的数据库操作Service
* @createDate 2024-06-17 14:58:31
*/
public interface LaboratoriesService extends IService<Laboratories> {

    List<Laboratories> getLabList();
}

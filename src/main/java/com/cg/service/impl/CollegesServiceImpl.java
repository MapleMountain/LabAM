package com.cg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cg.pojo.Colleges;
import com.cg.service.CollegesService;
import com.cg.mapper.CollegesMapper;
import org.springframework.stereotype.Service;

/**
* @author MIZUGI
* @description 针对表【colleges】的数据库操作Service实现
* @createDate 2024-06-17 14:58:31
*/
@Service
public class CollegesServiceImpl extends ServiceImpl<CollegesMapper, Colleges>
    implements CollegesService{

}





package com.cg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cg.pojo.Terms;
import com.cg.service.TermsService;
import com.cg.mapper.TermsMapper;
import org.springframework.stereotype.Service;

/**
* @author MIZUGI
* @description 针对表【terms】的数据库操作Service实现
* @createDate 2024-06-17 14:58:31
*/
@Service
public class TermsServiceImpl extends ServiceImpl<TermsMapper, Terms>
    implements TermsService{

}





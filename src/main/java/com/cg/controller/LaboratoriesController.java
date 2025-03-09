package com.cg.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cg.pojo.Laboratories;
import com.cg.service.LaboratoriesService;
import com.cg.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaboratoriesController {
    @Autowired
    LaboratoriesService laboratoriesService;
    @PostMapping("addLabs")//添加实验室
    public Result addLabs(String labName,@RequestParam Integer collegeId){
        Laboratories laboratories= new Laboratories(labName,collegeId);
        laboratoriesService.getBaseMapper().insert(laboratories);
        return Result.success();
    }
    @DeleteMapping("deleteLab")//删除实验室
    public Result deleteLab(Integer id){
        try {
            laboratoriesService.removeById(id);
        } catch (Exception e) {
            return Result.error("这个实验室处于分配状态，无法删除");
        }
        return Result.success();
    }
    @PutMapping("/updateLab")//更新实验室
    public Result updateLab(Integer id,String labName,Integer collegeId){
        LambdaUpdateWrapper<Laboratories> wrapper =new LambdaUpdateWrapper<>();
        wrapper.set(Laboratories::getLabName,labName)
                .set(Laboratories::getCollegeId,collegeId)
                .eq(Laboratories::getLabId,id);
        laboratoriesService.update(wrapper);
        return Result.success();
    }
    @GetMapping("getLabList")//获取实验室列表
    public Result getLabList(){
       List<Laboratories> list = laboratoriesService.getLabList();
       return Result.success(list);
    }
}

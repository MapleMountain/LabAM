package com.cg.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cg.anntaions.RequiresRole;
import com.cg.pojo.Colleges;
import com.cg.service.CollegesService;
import com.cg.utils.Result;
import com.cg.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CollegesController {
    @Autowired
    CollegesService collegesService;
    @PostMapping("/addCollege")
    @RequiresRole("sadmin")
    @ResponseBody
    public Result addCollege(String name){

            Colleges colleges = new Colleges();
            colleges.setCollegeName(name);
            collegesService.save(colleges);
            return Result.success();

    }
    @PostMapping("/update")
    @ResponseBody
    @RequiresRole("sadmin")
    public Result update(Integer id,String name){
            LambdaUpdateWrapper<Colleges> wrapper =new LambdaUpdateWrapper<>();
            wrapper.eq(Colleges::getCollegeId,id)
                    .set(Colleges::getCollegeName,name);
            collegesService.update(wrapper);
            return Result.success();

    }
    @GetMapping("getCollegeList")
    @ResponseBody
    public Result getCollegeList(){
        List<Colleges> list = collegesService.list();
        return Result.success(list);

    }
    @DeleteMapping("/deleteCollege")
    @RequiresRole("sdamin")
    @ResponseBody
    public Result deleteCollege(Integer id){
            try {
                collegesService.removeById(id);
            } catch (Exception e) {
                return Result.error("你必须删除该学院下的所有教室才能删除该学院");
            }
            return Result.success();
    }

}


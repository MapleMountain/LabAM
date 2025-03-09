package com.cg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cg.mapper.LaboratoriesMapper;
import com.cg.pojo.LabManagers;
import com.cg.service.LabManagersService;
import com.cg.service.LaboratoriesService;
import com.cg.service.UsersService;
import com.cg.utils.Result;
import com.cg.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class LabManagersController {
    @Autowired
    LaboratoriesMapper laboratoriesMapper;
    @Autowired
    UsersService usersService;
    @Autowired
    LabManagersService labManagersService;
    //指定实验室管理员 //任命管理员
    @PostMapping("/authorize")
    @ResponseBody
    public Result authorization(Integer uid){
        Map<String, Object> map = ThreadLocalUtil.get();
        String role = (String) map.get("role");
        if(role.equals("sadmin")) {
            usersService.auth(uid);
            return Result.success();
        }
        return Result.error("权限不足");
    }//撤销管理员权限后移除所有教室
    @PostMapping("/unauthorize")
    @ResponseBody
    public Result unauthorization(Integer uid){
        Map<Object, Object> map = ThreadLocalUtil.get();
        String role = (String) map.get("role");
        if(role.equals("sadmin")) {
            usersService.unauth(uid);
            return Result.success();
        }
        return Result.error("权限不足");
    }
    @PostMapping("/assign")//分配给实验室管理员教室
    @ResponseBody
    public Result assign(Integer managerId,Integer labId){
        Map<Object,Object> map = ThreadLocalUtil.get();
        String role = (String) map.get("role");
        if(role.equals("sadmin")) {
            try {
                labManagersService.assign(managerId,labId);
            } catch (Exception e) {
                return Result.error("已经分配了");
            }
            return Result.success();
        }
        return Result.error("权限不足");
    }
    @DeleteMapping("/unassign")//移除实验室管理员教室
    @ResponseBody
    public Result unassign(Integer id){
        Map<Object,Object> map = ThreadLocalUtil.get();
        String role = (String) map.get("role");
        if(role.equals("sadmin")) {
            labManagersService.unAssign(id);
            return Result.success();
        }
        return Result.error("权限不足");
    }

    @GetMapping("getManagers")
    @ResponseBody
    public Result getManagers(@RequestParam(required = false) Integer uid){
        Map<Object, Object> map = ThreadLocalUtil.get();
        uid = uid == null ? (Integer) map.get("id") : uid;
        List<LabManagers> managersList =labManagersService.getManagers(uid);
        return Result.success(managersList);
    }
    @GetMapping("getLabsforManager")
    public String getLabsforManager(Model model){
        Map<Object, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        List<LabManagers> managersList =labManagersService.getManagers(id);
        model.addAttribute("list",managersList);
        return "TLab";
    }
}

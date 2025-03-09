package com.cg.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cg.pojo.SafetyChecks;
import com.cg.service.SafetyChecksService;
import com.cg.utils.Result;
import com.cg.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class SafetyCheckesController {
    @Autowired
    SafetyChecksService safetyChecksService;
    @PostMapping("addReport")
    @ResponseBody
    public Result addReport(@RequestBody SafetyChecks safetyChecks) {
        Map<Object, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        safetyChecks.setManagerId(id);

        // 检查各个检查项，如果有0的情况，设置status为"anomaly"
        if (safetyChecks.getWindowCheck() == 0 ||
                safetyChecks.getElectricalCheck() == 0 ||
                safetyChecks.getFireSafetyCheck() == 0 ||
                safetyChecks.getEquipmentCheck() == 0 ||
                safetyChecks.getItemsPlacementCheck() == 0 ||
                safetyChecks.getCleanlinessCheck() == 0||
        safetyChecks.getOtherHazards() != null) {
            safetyChecks.setStatus("anomaly");//异常
        }
        System.out.println(safetyChecks.getOtherHazards());
        safetyChecksService.getBaseMapper().insert(safetyChecks);
        return Result.success();
    }

    @PatchMapping("resolved")//已处理
    @ResponseBody
    public Result resolved(Integer checkId){
        LambdaUpdateWrapper<SafetyChecks> wrapper =new LambdaUpdateWrapper<>();
        wrapper.set(SafetyChecks::getStatus,"resolved")
                .eq(SafetyChecks::getCheckId,checkId);
        safetyChecksService.update(wrapper);
        return Result.success();
    }
    @GetMapping("safetyList")
    public String safetyList(Model model){
        List<SafetyChecks> list = safetyChecksService.getlist();
        model.addAttribute("list",list);
        return "TSafetyCheck";
    }

}

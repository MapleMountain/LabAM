package com.cg.controller;

import com.cg.anntaions.RequiresRole;
import com.cg.pojo.Terms;
import com.cg.service.TermsService;
import com.cg.utils.Result;
import com.cg.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class TermsController {
    @Autowired
    TermsService termsService;
    @GetMapping("getTerms")
    public String getTerms(Model model){
        List<Terms> list = termsService.list();
        model.addAttribute("terms",list);
        return "Tterms";
    }
    @GetMapping("getTermsList")
    @ResponseBody
    public Result getTermsList(){
        List<Terms> list = termsService.list();
        return Result.success(list);
    }
    @PostMapping("/addTerm")//名称，开始时间，结束时间
    @ResponseBody
    @RequiresRole("sadmin")
    public Result addTerm(@RequestBody Terms terms){

            termsService.save(terms);
            return Result.success();

    }
    @PostMapping("/updateTerm")
    @ResponseBody
    public Result updateTerm(@RequestBody Terms terms){
        termsService.updateById(terms);
        return Result.success();
    }
    @DeleteMapping("/delTerm")
    @ResponseBody
    public Result delTerm(@RequestParam("id")Integer id){
        System.out.println(id);
        termsService.removeById(id);
        return Result.success();

    }
}

package com.cg.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalAccessException.class)
    public ModelAndView handleIllegalAccessException(IllegalAccessException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/401"); // 设置视图名称为错误页面
//        modelAndView.addObject("message", "你没有权限");
        return modelAndView;
    }

    // 可以添加更多异常处理方法
}

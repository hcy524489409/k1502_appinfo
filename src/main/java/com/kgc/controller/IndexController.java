package com.kgc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //直接去登录页面
    @RequestMapping("/toDevLogin")
    public String toDevLogin(){
        return "devlogin";
    }
}

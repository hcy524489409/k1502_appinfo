package com.kgc.controller;

import com.kgc.pojo.DevUser;
import com.kgc.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DevUserController {

    @Autowired
    private DevUserService devUserService;

    @RequestMapping("/login")
    public String login(String devcode, String devpassword, HttpSession session){
        //调用service层方法，实现在数据库查询匹配
        DevUser devUser = devUserService.devUserLogin(devcode, devpassword);

        //如果用户不存在返回到登录页面重新登录
        if(null == devUser){
            return "redirect:/index.jsp";
        }
        //如果用存在就存储用户信息到session域中
        session.setAttribute("devUser",devUser);
        //跳转到主页面
        return "redirect:/jsp/developer/main.jsp";
    }
}

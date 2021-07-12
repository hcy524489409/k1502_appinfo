package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.condition.AppInfoCondition;
import com.kgc.dto.AppInfoDto;
import com.kgc.pojo.AppInfo;
import com.kgc.pojo.DevUser;
import com.kgc.service.AppinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppInfoController {

    @Autowired
    private AppinfoService appinfoService;


    /**
     * 第一次访问的时候，这些条件是没有值的
     * @param appInfoCondition 封装的查询条件
     * @return
     */
    @RequestMapping("/list")
    public String list( AppInfoCondition appInfoCondition, HttpSession session, Model model){
        //因为第一次访问没有带任何的数据，需要对查询条件进行创建
        if(null == appInfoCondition){
            appInfoCondition = new AppInfoCondition();
            appInfoCondition.setPageNo(1);
        }
        //查询的时候需要获取登录用户的id
        DevUser devUser = (DevUser)session.getAttribute("devUser");
        //如果用户不存在，让用户回去登录
        if(null == devUser){
            return "redirect:/index.jsp";
        }
        appInfoCondition.setDevid(devUser.getId());

        //调用业务层的查询结果
        PageInfo<AppInfoDto> pageInfo = appinfoService.selectAppInfoByCondition(appInfoCondition);
        //把结果封装到域里面
        model.addAttribute("appInfoCondition",appInfoCondition);
        model.addAttribute("pageInfo",pageInfo);
        return "developer/appinfolist";
    }



}

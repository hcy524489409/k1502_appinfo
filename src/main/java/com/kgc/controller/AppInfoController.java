package com.kgc.controller;

import com.kgc.pojo.AppInfo;
import com.kgc.service.AppinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/app")
public class AppInfoController {

    @Autowired
    private AppinfoService appinfoService;

    @RequestMapping("/list")
    public String list(){

        return "developer/appinfolist";
    }



    /*@RequestMapping("/list")
    @ResponseBody
    public List<AppInfo> getAppInfos(){
        return appinfoService.selectAppInfoAll();
    }*/

}

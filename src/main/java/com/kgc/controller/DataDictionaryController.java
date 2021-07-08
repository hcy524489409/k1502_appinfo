package com.kgc.controller;

import com.kgc.pojo.DataDictionary;
import com.kgc.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/data")
public class DataDictionaryController {

    @Autowired
    private DataDictionaryService service;

    @RequestMapping("/dictionary")
    @ResponseBody
    public List<DataDictionary> getDictionarysByTypename(String typename){
        return service.selectDictionaryByTypename(typename);
    }

}

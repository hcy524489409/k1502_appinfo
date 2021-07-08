package com.kgc.test;

import com.kgc.pojo.DataDictionary;
import com.kgc.service.DataDictionaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class DataDictionaryTest {

    @Autowired
    private DataDictionaryService service;

    @Test
    public void test01(){
       // List<DataDictionary> dataDictionaries = service.selectDictionaryByTypename("APP状态");
        List<DataDictionary> dataDictionaries = service.selectDictionaryByTypename("所属平台");
        System.out.println(dataDictionaries);
    }
}

package com.kgc.service.impl;

import com.kgc.mapper.DataDictionaryMapper;
import com.kgc.pojo.DataDictionary;
import com.kgc.pojo.DataDictionaryExample;
import com.kgc.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryMapper dictionaryMapper;


    @Override
    public List<DataDictionary> selectDictionaryByTypename(String typename) {
        //创建条件对象
        DataDictionaryExample example = new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = example.createCriteria();

        //添加条件
        //如果条件为空
        if(null == typename || typename.equals("")){
            return null;
        }

        //如果传递过来的不空数据
        criteria.andTypenameEqualTo(typename);

        List<DataDictionary> dataDictionaries = dictionaryMapper.selectByExample(example);

        //如果返回值为空
        if (null == dataDictionaries || dataDictionaries.size() == 0){
            return null;
        }
        return dataDictionaries;
    }
}

package com.kgc.service;

import com.kgc.pojo.DataDictionary;

import java.util.List;

/**
 * 数据字典的业务层
 */
public interface DataDictionaryService {

    /**
     * 根据类型名称查询所有的数据类型
     * @param typename 类型名称
     * @return 符合条件的数据
     */
    List<DataDictionary> selectDictionaryByTypename(String typename);


}

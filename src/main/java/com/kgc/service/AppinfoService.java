package com.kgc.service;


import com.github.pagehelper.PageInfo;
import com.kgc.condition.AppInfoCondition;
import com.kgc.dto.AppInfoDto;
import com.kgc.pojo.AppInfo;

import java.util.List;

public interface AppinfoService {

    /**
     * 根据查询条件查询App信息
     * @param appInfoCondition 查询条件
     * @return
     */
    PageInfo<AppInfoDto> selectAppInfoByCondition(AppInfoCondition appInfoCondition);

    List<AppInfo> selectAppInfoAll();
}

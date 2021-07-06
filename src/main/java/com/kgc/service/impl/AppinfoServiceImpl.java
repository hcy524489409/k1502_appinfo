package com.kgc.service.impl;

import com.kgc.mapper.AppInfoMapper;
import com.kgc.pojo.AppInfo;
import com.kgc.service.AppinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppinfoServiceImpl implements AppinfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Override
    public List<AppInfo> selectAppInfoAll() {
        return appInfoMapper.selectByExample(null);
    }
}

package com.kgc.service.impl;

import com.kgc.mapper.DevUserMapper;
import com.kgc.pojo.DevUser;
import com.kgc.pojo.DevUserExample;
import com.kgc.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    @Override
    public DevUser devUserLogin(String devcode, String devpassword) {

        DevUserExample devUserExample = new DevUserExample();
        DevUserExample.Criteria criteria = devUserExample.createCriteria();

        //非空判断
        if(null == devcode || devcode.equals("")){
            return null;
        }
        if(null == devpassword && devpassword.equals("")){
            return null;
        }
        //添加查询条件
        criteria.andDevcodeEqualTo(devcode);
        criteria.andDevpasswordEqualTo(devpassword);
        //调用mapper层的查询方法
        List<DevUser> devUsers = devUserMapper.selectByExample(devUserExample);

        if(devUsers == null || devUsers.size() == 0){
            return null;
        }
        //return 满足条件的APP开发者对象
        return devUsers.get(0);
    }
}

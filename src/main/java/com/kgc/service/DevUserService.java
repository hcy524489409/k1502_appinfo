package com.kgc.service;

import com.kgc.pojo.DevUser;

/**
 * APP开发者接口
 */
public interface DevUserService {

    /**
     * app开发者登录功能
     * @param devcode 用户名
     * @param devpassword 密码
     * @return APP开发者用户对象
     */
    DevUser devUserLogin(String devcode,String devpassword);
}

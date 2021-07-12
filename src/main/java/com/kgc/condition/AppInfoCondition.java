package com.kgc.condition;

import com.kgc.utils.PageUtils;
import org.springframework.stereotype.Component;

/**
 * 用于封装APP信息的查询条件的类
 */
@Component
public class AppInfoCondition extends PageUtils {
    private String softwarename; //软件名称

    private Long status; //APP状态

    private Long flatformid; //所属平台

    private Long categorylevel1; // 一级分类

    private Long categorylevel2; // 二级分类

    private Long categorylevel3; // 三级分类

    private Long devid; //APP登录用户id

    public AppInfoCondition() {

    }

    public AppInfoCondition(Integer pageNo, Integer pageSize, String softwarename, Long status, Long flatformid, Long categorylevel1, Long categorylevel2, Long categorylevel3, Long devid) {
        super(pageNo, pageSize);
        this.softwarename = softwarename;
        this.status = status;
        this.flatformid = flatformid;
        this.categorylevel1 = categorylevel1;
        this.categorylevel2 = categorylevel2;
        this.categorylevel3 = categorylevel3;
        this.devid = devid;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getFlatformid() {
        return flatformid;
    }

    public void setFlatformid(Long flatformid) {
        this.flatformid = flatformid;
    }

    public Long getCategorylevel1() {
        return categorylevel1;
    }

    public void setCategorylevel1(Long categorylevel1) {
        this.categorylevel1 = categorylevel1;
    }

    public Long getCategorylevel2() {
        return categorylevel2;
    }

    public void setCategorylevel2(Long categorylevel2) {
        this.categorylevel2 = categorylevel2;
    }

    public Long getCategorylevel3() {
        return categorylevel3;
    }

    public void setCategorylevel3(Long categorylevel3) {
        this.categorylevel3 = categorylevel3;
    }

    public Long getDevid() {
        return devid;
    }

    public void setDevid(Long devid) {
        this.devid = devid;
    }
}

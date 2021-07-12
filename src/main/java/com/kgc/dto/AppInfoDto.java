package com.kgc.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用于封装app页面信息显示的类
 *  封装的数据
 *      主表 中大部分的字段
 *      连表  主键 要显示的字段
 *
 */
public class AppInfoDto {
    private Long id; // APP信息id

    private String softwarename;  //软件名称

    private String apkname; // APK名称

    private String supportrom;

    private String interfacelanguage;

    private BigDecimal softwaresize; //软件大小

    private Long devid;

    private String appinfo;

    private Long status; //状态

    private String statusname; //状态名称

    private Long flatformid;  //所属平台id

    private String flatformname; //所属平台名称

    private Long categorylevel3; // 三级分类id

    private String categorylevel3name; //3级分类名称

    private Long downloads; //下载次数


    private Long categorylevel1; //一级分类id

    private String categorylevel1name;  //一级分类名称

    private Long categorylevel2; //二级分类id

    private String categorylevel2name; //二级分类名称

    private Long versionid; //版本id

    private String versionname; //版本名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getApkname() {
        return apkname;
    }

    public void setApkname(String apkname) {
        this.apkname = apkname;
    }

    public String getSupportrom() {
        return supportrom;
    }

    public void setSupportrom(String supportrom) {
        this.supportrom = supportrom;
    }

    public String getInterfacelanguage() {
        return interfacelanguage;
    }

    public void setInterfacelanguage(String interfacelanguage) {
        this.interfacelanguage = interfacelanguage;
    }

    public BigDecimal getSoftwaresize() {
        return softwaresize;
    }

    public void setSoftwaresize(BigDecimal softwaresize) {
        this.softwaresize = softwaresize;
    }

    public Long getDevid() {
        return devid;
    }

    public void setDevid(Long devid) {
        this.devid = devid;
    }

    public String getAppinfo() {
        return appinfo;
    }

    public void setAppinfo(String appinfo) {
        this.appinfo = appinfo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public Long getFlatformid() {
        return flatformid;
    }

    public void setFlatformid(Long flatformid) {
        this.flatformid = flatformid;
    }

    public String getFlatformname() {
        return flatformname;
    }

    public void setFlatformname(String flatformname) {
        this.flatformname = flatformname;
    }

    public Long getCategorylevel3() {
        return categorylevel3;
    }

    public void setCategorylevel3(Long categorylevel3) {
        this.categorylevel3 = categorylevel3;
    }

    public String getCategorylevel3name() {
        return categorylevel3name;
    }

    public void setCategorylevel3name(String categorylevel3name) {
        this.categorylevel3name = categorylevel3name;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCategorylevel1() {
        return categorylevel1;
    }

    public void setCategorylevel1(Long categorylevel1) {
        this.categorylevel1 = categorylevel1;
    }

    public String getCategorylevel1name() {
        return categorylevel1name;
    }

    public void setCategorylevel1name(String categorylevel1name) {
        this.categorylevel1name = categorylevel1name;
    }

    public Long getCategorylevel2() {
        return categorylevel2;
    }

    public void setCategorylevel2(Long categorylevel2) {
        this.categorylevel2 = categorylevel2;
    }

    public String getCategorylevel2name() {
        return categorylevel2name;
    }

    public void setCategorylevel2name(String categorylevel2name) {
        this.categorylevel2name = categorylevel2name;
    }

    public Long getVersionid() {
        return versionid;
    }

    public void setVersionid(Long versionid) {
        this.versionid = versionid;
    }

    public String getVersionname() {
        return versionname;
    }

    public void setVersionname(String versionname) {
        this.versionname = versionname;
    }
}

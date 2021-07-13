package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.condition.AppInfoCondition;
import com.kgc.constant.AppConstant;
import com.kgc.dto.AppInfoDto;
import com.kgc.mapper.AppCategoryMapper;
import com.kgc.mapper.AppInfoMapper;
import com.kgc.mapper.AppVersionMapper;
import com.kgc.mapper.DataDictionaryMapper;
import com.kgc.pojo.*;
import com.kgc.service.AppinfoService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AppinfoServiceImpl implements AppinfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Autowired
    private DataDictionaryMapper dictionaryMapper; //数据字典表对应的mapper

    @Autowired
    private AppCategoryMapper categoryMapper; // 分类表对应的mapper

    @Autowired
    private AppVersionMapper versionMapper; // 版本对应的mapper

    @Override
    @Transactional(readOnly = true)
    public PageInfo<AppInfoDto> selectAppInfoByCondition(AppInfoCondition appInfoCondition) {

        //1.添加查询条件
        AppInfoExample appInfoExample = new AppInfoExample();
        AppInfoExample.Criteria appInfoExampleCriteria = appInfoExample.createCriteria();

        //添加用id作为查询条件
        if(null == appInfoCondition.getDevid()){
            return null; //如果没有用户，就不查询
        }else {
            appInfoExampleCriteria.andDevidEqualTo(appInfoCondition.getDevid());
        }

        //添加软件名称作为查询条件
        if(null != appInfoCondition.getSoftwarename() && !appInfoCondition.getSoftwarename().equals("")){
            appInfoExampleCriteria.andSoftwarenameLike("%"+appInfoCondition.getSoftwarename()+"%");
        }

        //添加 状态作为查询条件
        if(null != appInfoCondition.getStatus() && appInfoCondition.getStatus() != 0){
            appInfoExampleCriteria.andStatusEqualTo(appInfoCondition.getStatus());
        }

        //添加 所属平台作为查询条件
        if(null != appInfoCondition.getFlatformid() && appInfoCondition.getFlatformid() != 0){
            appInfoExampleCriteria.andFlatformidEqualTo(appInfoCondition.getFlatformid());
        }

        // 添加一级分类 作为查询条件
        if(null != appInfoCondition.getCategorylevel1() && appInfoCondition.getCategorylevel1() != 0){
            appInfoExampleCriteria.andCategorylevel1EqualTo(appInfoCondition.getCategorylevel1());
        }

        //添加二级分类 作为查询条件
        if(null != appInfoCondition.getCategorylevel2() && appInfoCondition.getCategorylevel2() !=0){
            appInfoExampleCriteria.andCategorylevel2EqualTo(appInfoCondition.getCategorylevel2());
        }

        //添加三级分类作为查询条件
        if(null != appInfoCondition.getCategorylevel3() && appInfoCondition.getCategorylevel3() != 0){
            appInfoExampleCriteria.andCategorylevel3EqualTo(appInfoCondition.getCategorylevel3());
        }

        //2.开启分页
        PageHelper.startPage(appInfoCondition.getPageNo(),appInfoCondition.getPageSize());
        //3.查询APP信息
        List<AppInfo> appInfos = appInfoMapper.selectByExample(appInfoExample);

        //创建分页工具类
        PageInfo pageInfo = new PageInfo(appInfos);

        //创建一个List<AppInfoDto>
        List<AppInfoDto> appInfoDtos = new ArrayList<AppInfoDto>();
        //4.根据查询到的id去查询  所属平台  状态   1、2、3级分类  APP版本号
        for(AppInfo appInfo:appInfos){
            //4.1根据查询到的状态id去数据字典表中把这条APP信息对应的APP状态查询出来 这是一个一对一的查询
            //创建数据字典表的查询条件
            DataDictionaryExample dictionaryExample01 = new DataDictionaryExample();
            DataDictionaryExample.Criteria dictionaryExample01Criteria = dictionaryExample01.createCriteria();

            //添加根据状态id和类型名称作为条件
            dictionaryExample01Criteria.andTypenameEqualTo(AppConstant.APP_STATUS_NAME);
            dictionaryExample01Criteria.andValueidEqualTo(appInfo.getStatus());

            //查询到的APP状态
            List<DataDictionary> dataDictionaries01 = dictionaryMapper.selectByExample(dictionaryExample01);

            //4.2 查询所属平台信息
            DataDictionaryExample dictionaryExample02 = new DataDictionaryExample();
            DataDictionaryExample.Criteria dictionaryExample02Criteria = dictionaryExample02.createCriteria();

            //添加所属平台id和类型作为查询条件
            dictionaryExample02Criteria.andTypenameEqualTo(AppConstant.APP_FLATFORM_NAME);
            dictionaryExample02Criteria.andValueidEqualTo(appInfo.getFlatformid());

            //查询 APP对应的所属平台
            List<DataDictionary> dataDictionaries02 = dictionaryMapper.selectByExample(dictionaryExample02);

            //4.3 查询一级分类
            //创建一级分类的查询条件
            AppCategory oneLeve = categoryMapper.selectByPrimaryKey(appInfo.getCategorylevel1());

            //4.4 查询二级分类
            AppCategory towLeve = categoryMapper.selectByPrimaryKey(appInfo.getCategorylevel2());

            //4.5查询三级分类
            AppCategory threeLeve = categoryMapper.selectByPrimaryKey(appInfo.getCategorylevel3());

            //4.6 查询最新版本号
            AppVersion appVersion = versionMapper.selectByPrimaryKey(appInfo.getVersionid());

            //5.把查询数据封装到AppInfoDto对象中
            AppInfoDto appInfoDto = new AppInfoDto();
            //给这里面的每个字段赋值
            //注册时间转换器
            ConvertUtils.register(new DateLocaleConverter(), Date.class);

            try {
                //把appInfo对象中的属性值复制到appInfoDto里面，只能复制属性名称相同的
                BeanUtils.copyProperties(appInfoDto,appInfo);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            //1.设置 APP状态的值
            appInfoDto.setStatusname(dataDictionaries01.get(0).getValuename());

            //2.设置所属平台的值
            appInfoDto.setFlatformname(dataDictionaries02.get(0).getValuename());

            //3.设置一级分类的值
            appInfoDto.setCategorylevel1name(oneLeve.getCategoryname());

            //4.设置二级分类的值
            appInfoDto.setCategorylevel2name(towLeve.getCategoryname());

            //5.设置三级分类的值
            appInfoDto.setCategorylevel3name(threeLeve.getCategoryname());

            //6.设置最新APP的版本号
            if(null == appVersion){ //因为有的版本没有
                appInfoDto.setVersionname(null);
            }else{
                appInfoDto.setVersionname(appVersion.getVersionno());
            }

            //把赋值完成后的对象添加到集合中
            appInfoDtos.add(appInfoDto);
        }
        //6. 使用appInfoDtos最终要显示的数据，替换掉APPinfo里面的数据
        pageInfo.setList(appInfoDtos);
        //7.return
        return pageInfo;
    }

    @Override
    public List<AppInfo> selectAppInfoAll() {
        return appInfoMapper.selectByExample(null);
    }

    @Override
    public PageInfo<AppInfoDto> selectAppInfoDtosByCondition(AppInfoCondition appInfoCondition) {

        //开启分页
        PageHelper.startPage(appInfoCondition.getPageNo(),appInfoCondition.getPageSize());

        List<AppInfoDto> appInfoDtos = appInfoMapper.selectAppInfos(appInfoCondition);

        //创建分页工具
        return new PageInfo<AppInfoDto>(appInfoDtos);
    }

    @Override
    public boolean isExistsAPKName(String apkname) {
        //创建一个查询条件
        AppInfoExample example = new AppInfoExample();
        AppInfoExample.Criteria criteria = example.createCriteria();

        //添加查询条件到条件类中
        criteria.andApknameEqualTo(apkname);

        //执行查询方法
        List<AppInfo> appInfos = appInfoMapper.selectByExample(example);

        if(null == appInfos || appInfos.size() == 0 ){
            return false; //表示用户输入没有重复
        }else {
            return true; //表示用户输入有重复
        }

    }
}

package com.kgc.mapper;

import com.kgc.condition.AppInfoCondition;
import com.kgc.dto.AppInfoDto;
import com.kgc.pojo.AppInfo;
import com.kgc.pojo.AppInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppInfoMapper {
    long countByExample(AppInfoExample example);

    int deleteByExample(AppInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    List<AppInfo> selectByExample(AppInfoExample example);

    AppInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppInfo record, @Param("example") AppInfoExample example);

    int updateByExample(@Param("record") AppInfo record, @Param("example") AppInfoExample example);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

    /**
     * 自定义的一个多表联查的方法
     * @param appInfoCondition 查询条件
     * @return
     */
    List<AppInfoDto> selectAppInfos(AppInfoCondition appInfoCondition);

}
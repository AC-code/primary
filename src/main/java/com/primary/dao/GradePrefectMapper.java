package com.primary.dao;

import com.primary.bean.GradePrefect;
import com.primary.bean.GradePrefectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradePrefectMapper {
    int countByExample(GradePrefectExample example);

    int deleteByExample(GradePrefectExample example);

    int insert(GradePrefect record);

    int insertSelective(GradePrefect record);

    List<GradePrefect> selectByExample(GradePrefectExample example);

    int updateByExampleSelective(@Param("record") GradePrefect record, @Param("example") GradePrefectExample example);

    int updateByExample(@Param("record") GradePrefect record, @Param("example") GradePrefectExample example);
}
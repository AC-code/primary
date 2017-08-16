package com.primary.dao;

import com.primary.bean.GradeCourseDetail;
import com.primary.bean.GradeCourseDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeCourseDetailMapper {
    int countByExample(GradeCourseDetailExample example);

    int deleteByExample(GradeCourseDetailExample example);

    int insert(GradeCourseDetail record);

    int insertSelective(GradeCourseDetail record);

    List<GradeCourseDetail> selectByExample(GradeCourseDetailExample example);

    int updateByExampleSelective(@Param("record") GradeCourseDetail record, @Param("example") GradeCourseDetailExample example);

    int updateByExample(@Param("record") GradeCourseDetail record, @Param("example") GradeCourseDetailExample example);
}
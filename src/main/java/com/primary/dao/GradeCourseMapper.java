package com.primary.dao;

import com.primary.bean.GradeCourse;
import com.primary.bean.GradeCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeCourseMapper {
    int countByExample(GradeCourseExample example);

    int deleteByExample(GradeCourseExample example);

    int deleteByPrimaryKey(Integer gCId);

    int insert(GradeCourse record);

    int insertSelective(GradeCourse record);

    List<GradeCourse> selectByExample(GradeCourseExample example);

    GradeCourse selectByPrimaryKey(Integer gCId);

    int updateByExampleSelective(@Param("record") GradeCourse record, @Param("example") GradeCourseExample example);

    int updateByExample(@Param("record") GradeCourse record, @Param("example") GradeCourseExample example);

    int updateByPrimaryKeySelective(GradeCourse record);

    int updateByPrimaryKey(GradeCourse record);
}
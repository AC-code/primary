package com.primary.dao;

import com.primary.bean.CourseTeacherExample;
import com.primary.bean.CourseTeacherKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTeacherMapper {
    int countByExample(CourseTeacherExample example);

    int deleteByExample(CourseTeacherExample example);

    int deleteByPrimaryKey(CourseTeacherKey key);

    int insert(CourseTeacherKey record);

    int insertSelective(CourseTeacherKey record);

    List<CourseTeacherKey> selectByExample(CourseTeacherExample example);

    int updateByExampleSelective(@Param("record") CourseTeacherKey record, @Param("example") CourseTeacherExample example);

    int updateByExample(@Param("record") CourseTeacherKey record, @Param("example") CourseTeacherExample example);
}
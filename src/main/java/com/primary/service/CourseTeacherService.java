package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.CourseTeacherExample;
import com.primary.bean.CourseTeacherKey;

public interface CourseTeacherService {
    public int countByExample(CourseTeacherExample example);

    public int deleteByExample(CourseTeacherExample example);

    public int deleteByPrimaryKey(CourseTeacherKey key);

    public int insert(CourseTeacherKey record);

    public int insertSelective(CourseTeacherKey record);

    public List<CourseTeacherKey> selectByExample(CourseTeacherExample example);

    public int updateByExampleSelective(@Param("record") CourseTeacherKey record, @Param("example") CourseTeacherExample example);

    public int updateByExample(@Param("record") CourseTeacherKey record, @Param("example") CourseTeacherExample example);
    
    public List<CourseTeacherKey> selectByParams(Integer gCId, Integer classid, Integer stuffid);
}

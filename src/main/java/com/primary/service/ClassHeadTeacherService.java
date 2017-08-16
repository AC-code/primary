package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.ClassHeadTeacher;
import com.primary.bean.ClassHeadTeacherExample;

public interface ClassHeadTeacherService {
    public int countByExample(ClassHeadTeacherExample example);

    public int deleteByExample(ClassHeadTeacherExample example);

    public int insert(ClassHeadTeacher record);

    public int insertSelective(ClassHeadTeacher record);

    public List<ClassHeadTeacher> selectByExample(ClassHeadTeacherExample example);

    public int updateByExampleSelective(@Param("record") ClassHeadTeacher record, @Param("example") ClassHeadTeacherExample example);

    public int updateByExample(@Param("record") ClassHeadTeacher record, @Param("example") ClassHeadTeacherExample example);
}

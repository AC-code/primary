package com.primary.dao;

import com.primary.bean.ClassHeadTeacher;
import com.primary.bean.ClassHeadTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassHeadTeacherMapper {
    int countByExample(ClassHeadTeacherExample example);

    int deleteByExample(ClassHeadTeacherExample example);

    int insert(ClassHeadTeacher record);

    int insertSelective(ClassHeadTeacher record);

    List<ClassHeadTeacher> selectByExample(ClassHeadTeacherExample example);

    int updateByExampleSelective(@Param("record") ClassHeadTeacher record, @Param("example") ClassHeadTeacherExample example);

    int updateByExample(@Param("record") ClassHeadTeacher record, @Param("example") ClassHeadTeacherExample example);
}
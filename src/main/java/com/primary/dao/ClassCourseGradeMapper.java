package com.primary.dao;

import com.primary.bean.ClassCourseGrade;
import com.primary.bean.ClassCourseGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassCourseGradeMapper {
    int countByExample(ClassCourseGradeExample example);

    int deleteByExample(ClassCourseGradeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassCourseGrade record);

    int insertSelective(ClassCourseGrade record);

    List<ClassCourseGrade> selectByExample(ClassCourseGradeExample example);

    ClassCourseGrade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassCourseGrade record, @Param("example") ClassCourseGradeExample example);

    int updateByExample(@Param("record") ClassCourseGrade record, @Param("example") ClassCourseGradeExample example);

    int updateByPrimaryKeySelective(ClassCourseGrade record);

    int updateByPrimaryKey(ClassCourseGrade record);
}
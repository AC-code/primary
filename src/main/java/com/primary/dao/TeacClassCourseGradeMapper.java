package com.primary.dao;

import com.primary.bean.TeacClassCourseGrade;
import com.primary.bean.TeacClassCourseGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacClassCourseGradeMapper {
    int countByExample(TeacClassCourseGradeExample example);

    int deleteByExample(TeacClassCourseGradeExample example);

    int insert(TeacClassCourseGrade record);

    int insertSelective(TeacClassCourseGrade record);

    List<TeacClassCourseGrade> selectByExample(TeacClassCourseGradeExample example);

    int updateByExampleSelective(@Param("record") TeacClassCourseGrade record, @Param("example") TeacClassCourseGradeExample example);

    int updateByExample(@Param("record") TeacClassCourseGrade record, @Param("example") TeacClassCourseGradeExample example);
}
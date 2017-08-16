package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.ClassCourseGrade;
import com.primary.bean.ClassCourseGradeExample;

public interface ClassCourseGradeService {
    public int countByExample(ClassCourseGradeExample example);

    public int deleteByExample(ClassCourseGradeExample example);

    public int deleteByPrimaryKey(Integer id);

    public int insert(ClassCourseGrade record);

    public int insertSelective(ClassCourseGrade record);

    public List<ClassCourseGrade> selectByExample(ClassCourseGradeExample example);

    public ClassCourseGrade selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("record") ClassCourseGrade record, @Param("example") ClassCourseGradeExample example);

    public int updateByExample(@Param("record") ClassCourseGrade record, @Param("example") ClassCourseGradeExample example);

    public int updateByPrimaryKeySelective(ClassCourseGrade record);

    public int updateByPrimaryKey(ClassCourseGrade record);
    
    public ClassCourseGradeExample createDefalutExample(ClassCourseGrade classCourseGrade);
}

package com.primary.dao;

import com.primary.bean.CourseTeacherDetail;
import com.primary.bean.CourseTeacherDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTeacherDetailMapper {
    int countByExample(CourseTeacherDetailExample example);

    int deleteByExample(CourseTeacherDetailExample example);

    int insert(CourseTeacherDetail record);

    int insertSelective(CourseTeacherDetail record);

    List<CourseTeacherDetail> selectByExample(CourseTeacherDetailExample example);

    int updateByExampleSelective(@Param("record") CourseTeacherDetail record, @Param("example") CourseTeacherDetailExample example);

    int updateByExample(@Param("record") CourseTeacherDetail record, @Param("example") CourseTeacherDetailExample example);
}
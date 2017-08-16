package com.primary.dao;

import com.primary.bean.TeacherClassCourseDetail;
import com.primary.bean.TeacherClassCourseDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherClassCourseDetailMapper {
    int countByExample(TeacherClassCourseDetailExample example);

    int deleteByExample(TeacherClassCourseDetailExample example);

    int insert(TeacherClassCourseDetail record);

    int insertSelective(TeacherClassCourseDetail record);

    List<TeacherClassCourseDetail> selectByExample(TeacherClassCourseDetailExample example);

    int updateByExampleSelective(@Param("record") TeacherClassCourseDetail record, @Param("example") TeacherClassCourseDetailExample example);

    int updateByExample(@Param("record") TeacherClassCourseDetail record, @Param("example") TeacherClassCourseDetailExample example);
}
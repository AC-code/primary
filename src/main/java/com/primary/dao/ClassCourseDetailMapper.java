package com.primary.dao;

import com.primary.bean.ClassCourseDetail;
import com.primary.bean.ClassCourseDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassCourseDetailMapper {
    int countByExample(ClassCourseDetailExample example);

    int deleteByExample(ClassCourseDetailExample example);

    int insert(ClassCourseDetail record);

    int insertSelective(ClassCourseDetail record);

    List<ClassCourseDetail> selectByExample(ClassCourseDetailExample example);

    int updateByExampleSelective(@Param("record") ClassCourseDetail record, @Param("example") ClassCourseDetailExample example);

    int updateByExample(@Param("record") ClassCourseDetail record, @Param("example") ClassCourseDetailExample example);
}
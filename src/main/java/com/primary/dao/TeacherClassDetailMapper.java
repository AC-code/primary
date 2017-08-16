package com.primary.dao;

import com.primary.bean.TeacherClassDetail;
import com.primary.bean.TeacherClassDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherClassDetailMapper {
    int countByExample(TeacherClassDetailExample example);

    int deleteByExample(TeacherClassDetailExample example);

    int insert(TeacherClassDetail record);

    int insertSelective(TeacherClassDetail record);

    List<TeacherClassDetail> selectByExample(TeacherClassDetailExample example);

    int updateByExampleSelective(@Param("record") TeacherClassDetail record, @Param("example") TeacherClassDetailExample example);

    int updateByExample(@Param("record") TeacherClassDetail record, @Param("example") TeacherClassDetailExample example);
}
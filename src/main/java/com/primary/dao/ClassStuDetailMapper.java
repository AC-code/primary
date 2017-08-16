package com.primary.dao;

import com.primary.bean.ClassStuDetail;
import com.primary.bean.ClassStuDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassStuDetailMapper {
    int countByExample(ClassStuDetailExample example);

    int deleteByExample(ClassStuDetailExample example);

    int insert(ClassStuDetail record);

    int insertSelective(ClassStuDetail record);

    List<ClassStuDetail> selectByExample(ClassStuDetailExample example);

    int updateByExampleSelective(@Param("record") ClassStuDetail record, @Param("example") ClassStuDetailExample example);

    int updateByExample(@Param("record") ClassStuDetail record, @Param("example") ClassStuDetailExample example);
}
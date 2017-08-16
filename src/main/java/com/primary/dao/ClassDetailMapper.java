package com.primary.dao;

import com.primary.bean.ClassDetail;
import com.primary.bean.ClassDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassDetailMapper {
    int countByExample(ClassDetailExample example);

    int deleteByExample(ClassDetailExample example);

    int insert(ClassDetail record);

    int insertSelective(ClassDetail record);

    List<ClassDetail> selectByExample(ClassDetailExample example);

    int updateByExampleSelective(@Param("record") ClassDetail record, @Param("example") ClassDetailExample example);

    int updateByExample(@Param("record") ClassDetail record, @Param("example") ClassDetailExample example);
}
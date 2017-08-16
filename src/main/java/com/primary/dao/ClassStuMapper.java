package com.primary.dao;

import com.primary.bean.ClassStu;
import com.primary.bean.ClassStuExample;
import com.primary.bean.ClassStuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassStuMapper {
    int countByExample(ClassStuExample example);

    int deleteByExample(ClassStuExample example);

    int deleteByPrimaryKey(ClassStuKey key);

    int insert(ClassStu record);

    int insertSelective(ClassStu record);

    List<ClassStu> selectByExample(ClassStuExample example);

    ClassStu selectByPrimaryKey(ClassStuKey key);

    int updateByExampleSelective(@Param("record") ClassStu record, @Param("example") ClassStuExample example);

    int updateByExample(@Param("record") ClassStu record, @Param("example") ClassStuExample example);

    int updateByPrimaryKeySelective(ClassStu record);

    int updateByPrimaryKey(ClassStu record);
}
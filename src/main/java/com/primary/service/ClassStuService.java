package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.ClassStu;
import com.primary.bean.ClassStuExample;
import com.primary.bean.ClassStuKey;

public interface ClassStuService {
    public int countByExample(ClassStuExample example);

    public int deleteByExample(ClassStuExample example);

    public int deleteByPrimaryKey(ClassStuKey key);

    public int insert(ClassStu record);

    public int insertSelective(ClassStu record);

    public List<ClassStu> selectByExample(ClassStuExample example);

    public ClassStu selectByPrimaryKey(ClassStuKey key);

    public int updateByExampleSelective(@Param("record") ClassStu record, @Param("example") ClassStuExample example);

    public int updateByExample(@Param("record") ClassStu record, @Param("example") ClassStuExample example);

    public int updateByPrimaryKeySelective(ClassStu record);

    public int updateByPrimaryKey(ClassStu record);
}

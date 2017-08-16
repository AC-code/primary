package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.Classes;
import com.primary.bean.ClassesExample;

public interface ClassesService {
    public int countByExample(ClassesExample example);

    public int deleteByExample(ClassesExample example);

    public int deleteByPrimaryKey(Integer classid);

    public int insert(Classes record);

    public int insertSelective(Classes record);

    public List<Classes> selectByExample(ClassesExample example);

    public Classes selectByPrimaryKey(Integer classid);

    public int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

    public int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example);

    public int updateByPrimaryKeySelective(Classes record);

    public int updateByPrimaryKey(Classes record);
}

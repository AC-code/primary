package com.primary.dao;

import com.primary.bean.HeadTeacherExample;
import com.primary.bean.HeadTeacherKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HeadTeacherMapper {
    int countByExample(HeadTeacherExample example);

    int deleteByExample(HeadTeacherExample example);

    int deleteByPrimaryKey(HeadTeacherKey key);

    int insert(HeadTeacherKey record);

    int insertSelective(HeadTeacherKey record);

    List<HeadTeacherKey> selectByExample(HeadTeacherExample example);

    int updateByExampleSelective(@Param("record") HeadTeacherKey record, @Param("example") HeadTeacherExample example);

    int updateByExample(@Param("record") HeadTeacherKey record, @Param("example") HeadTeacherExample example);
}
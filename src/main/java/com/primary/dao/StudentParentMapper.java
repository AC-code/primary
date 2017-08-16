package com.primary.dao;

import com.primary.bean.StudentParent;
import com.primary.bean.StudentParentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentParentMapper {
    int countByExample(StudentParentExample example);

    int deleteByExample(StudentParentExample example);

    int insert(StudentParent record);

    int insertSelective(StudentParent record);

    List<StudentParent> selectByExample(StudentParentExample example);

    int updateByExampleSelective(@Param("record") StudentParent record, @Param("example") StudentParentExample example);

    int updateByExample(@Param("record") StudentParent record, @Param("example") StudentParentExample example);
}
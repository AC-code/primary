package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.HeadTeacherExample;
import com.primary.bean.HeadTeacherKey;

public interface HeadTeacherService {
	public int countByExample(HeadTeacherExample example);

	public int deleteByExample(HeadTeacherExample example);

	public int deleteByPrimaryKey(HeadTeacherKey key);

	public int insert(HeadTeacherKey record);

	public int insertSelective(HeadTeacherKey record);

	public List<HeadTeacherKey> selectByExample(HeadTeacherExample example);

	public int updateByExampleSelective(@Param("record") HeadTeacherKey record, @Param("example") HeadTeacherExample example);

	public int updateByExample(@Param("record") HeadTeacherKey record, @Param("example") HeadTeacherExample example);
}

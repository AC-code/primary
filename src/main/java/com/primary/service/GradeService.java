package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.Grade;
import com.primary.bean.GradeExample;

public interface GradeService {
	public int countByExample(GradeExample example);

	public int deleteByExample(GradeExample example);

	public int deleteByPrimaryKey(Integer gradeid);

	public int insert(Grade record);

	public int insertSelective(Grade record);

	public List<Grade> selectByExample(GradeExample example);

	public Grade selectByPrimaryKey(Integer gradeid);

	public int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

	public int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

	public int updateByPrimaryKeySelective(Grade record);

	public int updateByPrimaryKey(Grade record);
}

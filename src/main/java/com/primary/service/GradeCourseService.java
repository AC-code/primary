package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.GradeCourse;
import com.primary.bean.GradeCourseExample;

public interface GradeCourseService {
	public int countByExample(GradeCourseExample example);

	public int deleteByExample(GradeCourseExample example);

	public int deleteByPrimaryKey(Integer gCId);

	public int insert(GradeCourse record);

	public int insertSelective(GradeCourse record);

	public List<GradeCourse> selectByExample(GradeCourseExample example);

	public GradeCourse selectByPrimaryKey(Integer gCId);

	public int updateByExampleSelective(@Param("record") GradeCourse record, @Param("example") GradeCourseExample example);

	public int updateByExample(@Param("record") GradeCourse record, @Param("example") GradeCourseExample example);

	public int updateByPrimaryKeySelective(GradeCourse record);

	public int updateByPrimaryKey(GradeCourse record);
}

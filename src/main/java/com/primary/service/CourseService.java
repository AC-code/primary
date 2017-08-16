package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.Course;
import com.primary.bean.CourseExample;

public interface CourseService {
	public int countByExample(CourseExample example);

	public int deleteByExample(CourseExample example);

	public int deleteByPrimaryKey(Integer courseid);

	public int insert(Course record);

	public int insertSelective(Course record);

	public List<Course> selectByExample(CourseExample example);

	public Course selectByPrimaryKey(Integer courseid);

	public int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

	public int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

	public int updateByPrimaryKeySelective(Course record);

	public int updateByPrimaryKey(Course record);
}

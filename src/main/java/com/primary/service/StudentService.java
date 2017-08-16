package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.Student;
import com.primary.bean.StudentExample;

public interface StudentService {
	public StudentExample betweenPrimaryExample(Integer min, Integer max);
	
	public int countByExample(StudentExample example);

	public int deleteByExample(StudentExample example);

	public int deleteByPrimaryKey(Integer stuid);
	
	public int removeStudentByPrimaryKey(Integer stuid);

	public int insert(Student record);
	
	public int insert(List<Student> records);
	
	public int createStudent(Student record);
	
	public int insertSelective(Student record);

	public List<Student> selectByExample(StudentExample example);

	public Student selectByPrimaryKey(Integer stuid);

	public int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

	public int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

	public int updateByPrimaryKeySelective(Student record);

	public int updateByPrimaryKey(Student record);
}

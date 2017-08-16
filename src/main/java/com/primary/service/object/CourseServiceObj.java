package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.Course;
import com.primary.bean.CourseExample;
import com.primary.dao.CourseMapper;
import com.primary.service.CourseService;

@Service
public class CourseServiceObj implements CourseService {
	@Resource
	private CourseMapper courseMapper;

	@Override
	public int countByExample(CourseExample example) {
		return courseMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CourseExample example) {
		return courseMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer courseid) {
		return courseMapper.deleteByPrimaryKey(courseid);
	}

	@Override
	public int insert(Course record) {
		return courseMapper.insert(record);
	}

	@Override
	public int insertSelective(Course record) {
		return courseMapper.insertSelective(record);
	}

	@Override
	public List<Course> selectByExample(CourseExample example) {
		return courseMapper.selectByExample(example);
	}

	@Override
	public Course selectByPrimaryKey(Integer courseid) {
		return courseMapper.selectByPrimaryKey(courseid);
	}

	@Override
	public int updateByExampleSelective(Course record, CourseExample example) {
		return courseMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Course record, CourseExample example) {
		return courseMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Course record) {
		return courseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Course record) {
		return courseMapper.updateByPrimaryKey(record);
	}

}

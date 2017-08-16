package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.GradeCourse;
import com.primary.bean.GradeCourseExample;
import com.primary.dao.GradeCourseMapper;
import com.primary.service.CourseService;
import com.primary.service.GradeCourseService;
import com.primary.service.GradeService;
import com.primary.util.CheckUtil;

@Service
public class GradeCourseServiceObj implements GradeCourseService {
	@Resource
	private GradeCourseMapper gradeCourseMapper;
	@Resource
	private GradeService gradeService;
	@Resource
	private CourseService courseService;
	
	@Override
	public int countByExample(GradeCourseExample example) {
		return gradeCourseMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(GradeCourseExample example) {
		return gradeCourseMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer gCId) {
		return gradeCourseMapper.deleteByPrimaryKey(gCId);
	}

	@Override
	public int insert(GradeCourse record) {
		return gradeCourseMapper.insert(record);
	}

	@Override
	public int insertSelective(GradeCourse record) {
		return gradeCourseMapper.insertSelective(record);
	}

	@Override
	public List<GradeCourse> selectByExample(GradeCourseExample example) {
		return gradeCourseMapper.selectByExample(example);
	}

	@Override
	public GradeCourse selectByPrimaryKey(Integer gCId) {
		return gradeCourseMapper.selectByPrimaryKey(gCId);
	}

	@Override
	public int updateByExampleSelective(GradeCourse record, GradeCourseExample example) {
		return gradeCourseMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(GradeCourse record, GradeCourseExample example) {
		return gradeCourseMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(GradeCourse record) {
		return gradeCourseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GradeCourse record) {
		return gradeCourseMapper.updateByPrimaryKey(record);
	}
}

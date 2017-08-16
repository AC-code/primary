package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.CourseTeacherExample;
import com.primary.bean.CourseTeacherExample.Criteria;
import com.primary.bean.CourseTeacherKey;
import com.primary.dao.CourseTeacherMapper;
import com.primary.service.CourseTeacherService;

@Service
public class CourseTeacherServiceObj implements CourseTeacherService {
	@Resource
	private CourseTeacherMapper courseTeacherMapper;
	
	@Override
	public int countByExample(CourseTeacherExample example) {
		return courseTeacherMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CourseTeacherExample example) {
		return courseTeacherMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(CourseTeacherKey key) {
		return courseTeacherMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(CourseTeacherKey record) {
		return courseTeacherMapper.insert(record);
	}

	@Override
	public int insertSelective(CourseTeacherKey record) {
		return courseTeacherMapper.insertSelective(record);
	}

	@Override
	public List<CourseTeacherKey> selectByExample(CourseTeacherExample example) {
		return courseTeacherMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(CourseTeacherKey record, CourseTeacherExample example) {
		return courseTeacherMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CourseTeacherKey record, CourseTeacherExample example) {
		return courseTeacherMapper.updateByExample(record, example);
	}

	@Override
	public List<CourseTeacherKey> selectByParams(Integer gCId, Integer classid, Integer stuffid) {
		CourseTeacherExample example = new CourseTeacherExample();
		
		Criteria criteria = example.createCriteria();
		
		if (gCId != null) {
			criteria.andGCIdEqualTo(gCId);
		}
		
		if (classid != null) {
			criteria.andClassidEqualTo(classid);
		}
		
		if (stuffid != null) {
			criteria.andStuffidEqualTo(stuffid);
		}
		
		return selectByExample(example);
	}

}

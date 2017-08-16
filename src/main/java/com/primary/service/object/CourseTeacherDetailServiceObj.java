package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.primary.bean.CourseTeacherDetail;
import com.primary.bean.CourseTeacherDetailExample;
import com.primary.bean.CourseTeacherDetailExample.Criteria;
import com.primary.dao.CourseTeacherDetailMapper;
import com.primary.service.CourseTeacherDetailService;

@Service
public class CourseTeacherDetailServiceObj implements CourseTeacherDetailService{
	@Resource 
	private CourseTeacherDetailMapper courseTeacherDetailMapper;

	@Override
	public int countByExample(CourseTeacherDetailExample example) {
		return courseTeacherDetailMapper.countByExample(example);
	}

	@Override
	public List<CourseTeacherDetail> selectByExample(CourseTeacherDetailExample example) {
		return courseTeacherDetailMapper.selectByExample(example);
	}

	@Override
	public List<CourseTeacherDetail> selectByParms(String name, Integer stuffid, Integer gCId, Integer classid) {
		return selectByExample(getDefaultExample(name, stuffid, gCId, classid));
	}
	
	public CourseTeacherDetailExample getDefaultExample(String name, Integer stuffid, Integer gCId, Integer classid) {
		CourseTeacherDetailExample example = new CourseTeacherDetailExample();
		
		Criteria criteria = example.createCriteria();
		
		if (!StringUtils.isEmpty(name)) {
			criteria.andNameLike(name);
		}
		
		if (stuffid != null) {
			criteria.andStuffidEqualTo(stuffid);
		}
		
		if (gCId != null) {
			criteria.andGCIdEqualTo(gCId);
		}
		
		if (classid != null) {
			criteria.andClassidEqualTo(classid);
		}
		
		return example;
	}
}

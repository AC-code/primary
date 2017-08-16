package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.primary.bean.TeacherClassCourseDetail;
import com.primary.bean.TeacherClassCourseDetailExample;
import com.primary.bean.TeacherClassCourseDetailExample.Criteria;
import com.primary.dao.TeacherClassCourseDetailMapper;
import com.primary.service.TeacherClassCourseDetailService;
import com.primary.util.SQLUtil;

@Service
public class TeacherClassCourseDetailServiceObj implements TeacherClassCourseDetailService {
	@Resource
	private TeacherClassCourseDetailMapper teacherClassCourseDetailMapper;
	
	@Override
	public int countByExample(TeacherClassCourseDetailExample example) {
		return teacherClassCourseDetailMapper.countByExample(example);
	}

	@Override
	public List<TeacherClassCourseDetail> selectByExample(TeacherClassCourseDetailExample example) {
		return teacherClassCourseDetailMapper.selectByExample(example);
	}

	@Override
	public TeacherClassCourseDetailExample createDefaultExample(TeacherClassCourseDetail detail) {
		TeacherClassCourseDetailExample example = new TeacherClassCourseDetailExample();
		
		if (detail == null) {
			return example;
		}
		
		Criteria criteria = example.createCriteria();
		
		if (!StringUtils.isEmpty(detail.getCoursename())) {
			criteria.andCoursenameLike(SQLUtil.toLike(detail.getCoursename()));
		}
		
		if (detail.getgCId() != null) {
			criteria.andGCIdEqualTo(detail.getgCId());
		}
		
		if (detail.getStuffid() != null) {
			criteria.andStuffidEqualTo(detail.getStuffid());
		}
		
		if (detail.getClassid() != null) {
			criteria.andClassidEqualTo(detail.getClassid());
		}
		
		return example;
	}

}

package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primary.bean.TeacClassCourseGrade;
import com.primary.bean.TeacClassCourseGradeExample;
import com.primary.bean.TeacClassCourseGradeExample.Criteria;
import com.primary.dao.TeacClassCourseGradeMapper;
import com.primary.service.TeacClassCourseGradeService;
import com.primary.util.SQLUtil;

@Service
public class TeacClassCourseGradeServiceObj implements TeacClassCourseGradeService {
	@Resource
	private TeacClassCourseGradeMapper teacClassCourseGradeMapper;
	
	@Override
	public int countByExample(TeacClassCourseGradeExample example) {
		return teacClassCourseGradeMapper.countByExample(example);
	}

	@Override
	public List<TeacClassCourseGrade> selectByExample(TeacClassCourseGradeExample example) {
		return teacClassCourseGradeMapper.selectByExample(example);
	}

	@Override
	public TeacClassCourseGradeExample createDefaultExample(TeacClassCourseGrade record) {
		TeacClassCourseGradeExample example = new TeacClassCourseGradeExample();
		
		if (record == null) {
			return example;
		}
		
		Criteria criteria = example.createCriteria();
		
		if (record.getStuffid() != null) {
			criteria.andStuffidEqualTo(record.getStuffid());
		}
		
		if (record.getId() != null) {
			criteria.andIdEqualTo(record.getId());
		}
		
		if (record.getClassid() != null) {
			criteria.andClassidEqualTo(record.getClassid());
		}
		
		if (record.getgCId() != null) {
			criteria.andGCIdEqualTo(record.getgCId());
		}
		
		if (!StringUtils.isEmpty(record.getName())) {
			criteria.andNameLike(SQLUtil.toLike(record.getName()));
		}
		
		return example;
	}

}

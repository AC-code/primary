package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.primary.bean.TeacherClassDetail;
import com.primary.bean.TeacherClassDetailExample;
import com.primary.bean.TeacherClassDetailExample.Criteria;
import com.primary.dao.TeacherClassDetailMapper;
import com.primary.service.TeacherClassDetailService;
import com.primary.util.SQLUtil;

@Service
public class TeacherClassDetailServiceObj implements TeacherClassDetailService {
	@Resource
	private TeacherClassDetailMapper teacherClassDetailMapper;
	
	@Override
	public int countByExample(TeacherClassDetailExample example) {
		return teacherClassDetailMapper.countByExample(example);
	}

	@Override
	public List<TeacherClassDetail> selectByExample(TeacherClassDetailExample example) {
		return teacherClassDetailMapper.selectByExample(example);
	}

	@Override
	public TeacherClassDetailExample createDefaultExample(TeacherClassDetail detail) {
		TeacherClassDetailExample example = new TeacherClassDetailExample();
		
		if (detail == null) {
			return example;
		}
	
		Criteria criteria = example.createCriteria();
		
		if (detail.getStuffid() != null) {
			criteria.andStuffidEqualTo(detail.getStuffid());
		}
		
		if (!StringUtils.isEmpty(detail.getSessnname())) {
			criteria.andSessnnameLike(SQLUtil.toLike(detail.getSessnname()));
		}
		
		if (!StringUtils.isEmpty(detail.getGradename())) {
			criteria.andGradenameLike(SQLUtil.toLike(detail.getGradename()));
		}
		
		if (!StringUtils.isEmpty(detail.getClassname())) {
			criteria.andClassnameLike(SQLUtil.toLike(detail.getClassname()));
		}
		
		if (detail.getClassid() != null) {
			criteria.andClassidEqualTo(detail.getClassid());
		}
		
		return example;
	}

}

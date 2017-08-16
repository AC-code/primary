package com.primary.service.object;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.primary.bean.ClassCourseDetail;
import com.primary.bean.ClassCourseDetailExample;
import com.primary.bean.ClassCourseDetailExample.Criteria;
import com.primary.dao.ClassCourseDetailMapper;
import com.primary.service.ClassCourseDetailService;
import com.primary.service.CourseTeacherService;
import com.primary.util.SQLUtil;

@Service
public class ClassCourseDetailServiceObj implements ClassCourseDetailService {
	@Resource
	private ClassCourseDetailMapper classCourseDetailMapper;
	
	@Override
	public int countByExample(ClassCourseDetailExample example) {
		return classCourseDetailMapper.countByExample(example);
	}

	@Override
	public List<ClassCourseDetail> selectByExample(ClassCourseDetailExample example) {
		return classCourseDetailMapper.selectByExample(example);
	}

	@Override
	public Map<String, Object> selectByParams(Integer gCId, Integer classid, String coursename) {
		ClassCourseDetailExample example = new ClassCourseDetailExample();
		Criteria criteria = example.createCriteria();
		
		if (gCId != null) {
			criteria.andGCIdEqualTo(gCId);
		}
		
		if (classid != null) {
			criteria.andClassidEqualTo(classid);
		}
		
		if ( !StringUtils.isEmpty(coursename) ) {
			criteria.andCoursenameLike(SQLUtil.toLike(coursename));
		}
		
		List datas = selectByExample(example);
		Integer total = countByExample(example);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("datas", datas);
		result.put("total", total);
		
		return result;
	}

	
}

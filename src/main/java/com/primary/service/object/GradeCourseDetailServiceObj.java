package com.primary.service.object;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.GradeCourseDetail;
import com.primary.bean.GradeCourseDetailExample;
import com.primary.bean.GradeCourseDetailExample.Criteria;
import com.primary.dao.GradeCourseDetailMapper;
import com.primary.service.GradeCourseDetailService;
import com.primary.util.Log;
import com.primary.util.MapUtil;
import com.primary.util.SQLUtil;

@Service
public class GradeCourseDetailServiceObj implements GradeCourseDetailService {
	@Resource
	private GradeCourseDetailMapper gradeCourseDetailMapper;
	
	@Override
	public int countByExample(GradeCourseDetailExample example) {
		return gradeCourseDetailMapper.countByExample(example);
	}

	@Override
	public List<GradeCourseDetail> selectByExample(GradeCourseDetailExample example) {
		return gradeCourseDetailMapper.selectByExample(example);
	}

	@Override
	public Map selectByParams(String coursename, Integer gCId, Integer courseid, Integer gradeid) {
		GradeCourseDetailExample example = new GradeCourseDetailExample();
		Criteria criteria = example.createCriteria();
		
		if (courseid != null) {
			criteria.andCourseidEqualTo(courseid);
		}
		
		if (coursename != null && coursename.length() > 0) {
			criteria.andCoursenameLike(SQLUtil.toLike(coursename));
		}
		
		if (gCId != null) {
			criteria.andGCIdEqualTo(gradeid);
		}
		
		if (gradeid != null) {
			criteria.andGradeidEqualTo(gradeid);
		}
		
		List datas = selectByExample(example);
		
		Integer total = countByExample(example);
		
		return MapUtil.getMap("total", total, "datas", datas);
	}

}

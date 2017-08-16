package com.primary.service;

import java.util.List;
import java.util.Map;

import com.primary.bean.GradeCourseDetail;
import com.primary.bean.GradeCourseDetailExample;

public interface GradeCourseDetailService {
	public int countByExample(GradeCourseDetailExample example);
	
	public List<GradeCourseDetail> selectByExample(GradeCourseDetailExample example);
	
	public Map selectByParams(String coursename, Integer gCId, Integer courseid, Integer gradeid);
}

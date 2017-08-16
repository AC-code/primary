package com.primary.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.primary.annotation.RequestPermission;
import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.bean.GradeCourse;
import com.primary.service.GradeCourseDetailService;
import com.primary.service.GradeCourseService;
import com.primary.util.CheckUtil;
import com.primary.util.JSONUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="/gradeCourse")
@RequestPermission(role=RequestPermissionParser.role_stuff)
public class GradeCourseController {
	@Resource
	private GradeCourseService gradeCourseService;
	@Resource
	private GradeCourseDetailService gradeCourseDetailService;
	
	@ResponseBody
	@RequestMapping(value="/findGradeCourse")
	public String findGradeCourse(Integer page, Integer rows, String coursename, Integer gCId, Integer courseid, Integer gradeid) {
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		Map resultMap = gradeCourseDetailService.selectByParams(coursename, gCId, courseid, gradeid);
		Integer total = (Integer) resultMap.get("total");
		List datas = (List) resultMap.get("datas");
		
		Log.info(datas);
		
		return JSONUtil.getJSonList(total, datas).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/addGradeCourse") 
	public String addGradeCourse(Integer courseid, Integer gradeid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(courseid, courseid)) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		gradeCourseService.insert(new GradeCourse(null, courseid, gradeid));
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteGradeCourse") 
	public String deleteGradeCourse(Integer gCId) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(gCId)) {
			result.put("message", "删除失败,存在非法数据");
			
			return result.toString();
		}
		gradeCourseService.deleteByPrimaryKey(gCId);
		
		result.put("message", "删除成功");
		
		return result.toString();
	}
}

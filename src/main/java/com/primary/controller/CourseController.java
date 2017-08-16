package com.primary.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.primary.annotation.RequestPermission;
import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.bean.Course;
import com.primary.bean.CourseExample;
import com.primary.bean.CourseExample.Criteria;
import com.primary.service.CourseService;
import com.primary.util.CheckUtil;
import com.primary.util.Log;

@Controller
@RequestPermission(role=RequestPermissionParser.role_admin)
public class CourseController {
	@Resource
	private CourseService courseService;
	
	@ResponseBody
	@RequestMapping(value="/course/findCourse")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String findStudent(Integer page, Integer rows, Integer fstuid, Integer courseid, String coursename) {
		CourseExample courseExample = new CourseExample();
		
		//构造查询条件
		Criteria criteria = courseExample.createCriteria();
		if (courseid != null) {
			criteria.andCourseidEqualTo(courseid);
		}
		if (coursename != null && coursename.length() > 0) {
			criteria.andCoursenameLike("%" + coursename + "%");
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<Course> courses = courseService.selectByExample(courseExample);
		
		JSONArray array = new JSONArray(courses);
		
		Log.info(array);
		
		JSONObject result = new JSONObject();
		
		result.put("total", courseService.countByExample(courseExample));
		result.put("rows", array);
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/course/courseAdd")
	public String studentAdd(Integer courseid, String coursename) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(courseid, coursename) || coursename.length() < 1) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		courseService.insert(new Course(courseid, coursename));
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/course/courseDelete")
	public String studentDelete(Integer courseid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(courseid)) {
			result.put("message", "删除失败,存在非法数据");
			
			return result.toString();
		}
		
		courseService.deleteByPrimaryKey(courseid);
		
		result.put("message", "删除成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/course/courseUpdate")
	public String studentUpdate(Integer courseid, String coursename) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(courseid, coursename) || coursename.length() < 1) {
			result.put("message", "修改失败,存在非法数据");
			
			return result.toString();
		}
		
		courseService.updateByPrimaryKeySelective(new Course(courseid, coursename));
		
		result.put("message", "修改成功");
		
		return result.toString();
	}
}

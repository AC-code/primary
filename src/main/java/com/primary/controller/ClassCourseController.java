package com.primary.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.primary.annotation.RequestPermission;
import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.bean.ClassCourseDetail;
import com.primary.bean.CourseTeacherDetail;
import com.primary.bean.CourseTeacherKey;
import com.primary.service.ClassCourseDetailService;
import com.primary.service.CourseTeacherDetailService;
import com.primary.service.CourseTeacherService;
import com.primary.util.CheckUtil;
import com.primary.util.JSONUtil;
import com.sun.org.glassfish.external.statistics.annotations.Reset;

@Controller
@RequestMapping(value="/classCourse")
@RequestPermission(role=RequestPermissionParser.role_stuff)
public class ClassCourseController {
	@Resource
	private ClassCourseDetailService classCourseDetailService;
	@Resource
	private CourseTeacherDetailService courseTeacherDetailService;
	@Resource
	private CourseTeacherService courseTeacherService;
	
	@ResponseBody
	@RequestMapping(value="/findClassCourse")
	public String findClassCourse(Integer page, Integer rows, Integer gCId, Integer classid, String coursename) {
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		Map<String, Object> queryResult = classCourseDetailService.selectByParams(gCId, classid, coursename);
		List<ClassCourseDetail> datas = (List<ClassCourseDetail>) queryResult.get("datas");
		Integer total = (Integer) queryResult.get("total");
		
		//根据查到的课程去查找其对应的教师的信息，并拼装到新的列中
		List<List<String>> teacherLists = new ArrayList<List<String>>();
		//获取一个查询到的课程
		for (ClassCourseDetail courseDetail : datas) {
			List<String> teachers = new ArrayList<String>();
			//根据课程获取教师列表
			List<CourseTeacherDetail> teacherDetails = courseTeacherDetailService.selectByParms(null, null, courseDetail.getgCId(), courseDetail.getClassid());
			//提取列表中的教师名称
			for (CourseTeacherDetail teacherDetail : teacherDetails) {
				teachers.add(teacherDetail.getName());
			}
			//把教师名字们加入到列表中
			teacherLists.add(teachers);
		}
		
		JSONArray array = JSONUtil.addListCol(datas, teacherLists, "stuffnames");
		
		return JSONUtil.getJsonObj("total", total, "rows", array);
	}
	
	@ResponseBody
	@RequestMapping(value="/findCourseTeacher")
	public String findCourseTeacher(Integer gCId, Integer classid) {
		if (CheckUtil.nullCheck(gCId, classid)) {
			return JSONUtil.getJsonObj("message", "存在错误查询数据");
		}
		
		List<CourseTeacherDetail> queryResult = courseTeacherDetailService.selectByParms(null, null, gCId, classid);
		
		return JSONUtil.getJSonList(null, queryResult).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/addClassCourseTeacher")
	public String addClassCourseTeacher(Integer gCId, Integer classid, Integer stuffid) {
		if (CheckUtil.nullCheck(gCId, classid, stuffid)) {
			return JSONUtil.getJsonObj("message", "添加失败,存在非法数据");
		}
		
		if (!courseTeacherService.selectByParams(gCId, classid, stuffid).isEmpty()) {
			return JSONUtil.getJsonObj("message", "添加失败,存在重复的任命");
		}
		
		CourseTeacherKey record = new CourseTeacherKey();
		record.setClassid(classid);
		record.setgCId(gCId);
		record.setStuffid(stuffid);
		courseTeacherService.insert(record);
		
		return JSONUtil.getJsonObj("message", "添加成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteClassCourseTeacher") 
	public String deleteClassCourse(Integer gCId, Integer classid, Integer stuffid) {
		if (CheckUtil.nullCheck(gCId, classid, stuffid)) {
			return JSONUtil.getJsonObj("message", "删除失败,存在非法数据");
		}
		
		if (courseTeacherService.selectByParams(gCId, classid, stuffid).isEmpty()) {
			return JSONUtil.getJsonObj("message", "删除失败,不存在改任命");
		}
		
		CourseTeacherKey record = new CourseTeacherKey();
		record.setClassid(classid);
		record.setgCId(gCId);
		record.setStuffid(stuffid);
		courseTeacherService.deleteByPrimaryKey(record);
		
		return JSONUtil.getJsonObj("message", "删除成功");
	}
}

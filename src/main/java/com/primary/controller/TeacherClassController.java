package com.primary.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import com.github.pagehelper.PageHelper;
import com.primary.annotation.RequestPermission;
import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.bean.TeacherClassCourseDetail;
import com.primary.bean.TeacherClassCourseDetailExample;
import com.primary.bean.TeacherClassDetail;
import com.primary.bean.TeacherClassDetailExample;
import com.primary.service.TeacherClassCourseDetailService;
import com.primary.service.TeacherClassDetailService;
import com.primary.util.JSONUtil;

@Controller
@RequestMapping(value="/teacher")
@RequestPermission(role=RequestPermissionParser.role_stuff, isStrict=true)
public class TeacherClassController {
	@Resource
	private TeacherClassCourseDetailService teacherClassCourseDetailService;
	@Resource
	private TeacherClassDetailService teacherClassDetailService;
	
	@ResponseBody
	@RequestMapping(value="/findTeacherClass")
	public String findTeacherClass(Integer page, Integer rows, Integer stuffid, String sessnname, String gradename) {
		TeacherClassDetail detail = new TeacherClassDetail();
		detail.setStuffid(stuffid);
		detail.setSessnname(sessnname);
		detail.setGradename(gradename);
		TeacherClassDetailExample example = teacherClassDetailService.createDefaultExample(detail);
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<TeacherClassDetail> datas = teacherClassDetailService.selectByExample(example);
		
		Integer total = teacherClassDetailService.countByExample(example);
		
		return JSONUtil.getJSonList(total, datas).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/findTeacherClassCourse")
	public String findTeacherClassCourse(Integer page, Integer rows, Integer stuffid, Integer classid, String coursename) {
		TeacherClassCourseDetail detail = new TeacherClassCourseDetail();
		detail.setStuffid(stuffid);
		detail.setClassid(classid);
		detail.setCoursename(coursename);
		TeacherClassCourseDetailExample example = teacherClassCourseDetailService.createDefaultExample(detail);
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<TeacherClassCourseDetail> datas = teacherClassCourseDetailService.selectByExample(example);
		
		Integer total = teacherClassCourseDetailService.countByExample(example);
		
		return JSONUtil.getJSonList(total, datas).toString();
	}
}

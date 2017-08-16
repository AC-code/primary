package com.primary.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.primary.annotation.RequestPermission;
import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.bean.ClassCourseGrade;
import com.primary.bean.TeacClassCourseGrade;
import com.primary.bean.TeacClassCourseGradeExample;
import com.primary.service.ClassCourseGradeService;
import com.primary.service.TeacClassCourseGradeService;
import com.primary.util.CheckUtil;
import com.primary.util.JSONUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="/classCourseGrade")
@RequestPermission(role=RequestPermissionParser.role_stuff)
public class ClassCourseGradeController {
	@Resource
	private ClassCourseGradeService classCourseGradeService;
	@Resource
	private TeacClassCourseGradeService teacClassCourseGradeService;
	
	@ResponseBody
	@RequestMapping(value="/findClassCourseGrade")
	public String findClassCourseGrade(Integer page, Integer rows, Integer stuffid, Integer classid, Integer gCId, String name) {
		if (stuffid == null) {
			return JSONUtil.getJsonObj("message", "参数出错");
		}
		
		TeacClassCourseGrade record = new TeacClassCourseGrade();
		record.setClassid(classid);
		record.setgCId(gCId);
		record.setName(name);
		record.setStuffid(stuffid);
		
		Log.info(record);
		
		TeacClassCourseGradeExample example = teacClassCourseGradeService.createDefaultExample(record);
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		List<TeacClassCourseGrade> list = teacClassCourseGradeService.selectByExample(example);
		
		Integer total = teacClassCourseGradeService.countByExample(example);
		
		return JSONUtil.getJSonList(total, list).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/addClassCourseService")
	public String addClassCourseService(Integer classid, Integer gCId, String name) {
		if (CheckUtil.nullCheck(classid, gCId, name)) {
			return JSONUtil.getJsonObj("message", "添加失败,存在非法数据");
		}
		
		ClassCourseGrade record = new ClassCourseGrade();
		record.setClassid(classid);
		record.setgCId(gCId);
		record.setName(name);
		
		if (!classCourseGradeService.selectByExample(classCourseGradeService.createDefalutExample(record)).isEmpty()) {
			return JSONUtil.getJsonObj("message", "添加失败,存在相同数据");
		}
		
		classCourseGradeService.insert(record);
		
		return JSONUtil.getJsonObj("message", "添加成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteClassCourseService")
	public String deleteClassCourseService(Integer id) {
		if (CheckUtil.nullCheck(id)) {
			return JSONUtil.getJsonObj("message", "删除失败,存在非法数据");
		}
		
		if (classCourseGradeService.selectByPrimaryKey(id) == null) {
			return JSONUtil.getJsonObj("message", "删除失败,不存在该数据");
		}
		
		classCourseGradeService.deleteByPrimaryKey(id);
		
		return JSONUtil.getJsonObj("message", "删除成功"); 
	}
}

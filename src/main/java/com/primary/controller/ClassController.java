package com.primary.controller;

import java.util.ArrayList;
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
import com.primary.bean.ClassDetail;
import com.primary.bean.ClassDetailExample;
import com.primary.bean.ClassHeadTeacher;
import com.primary.bean.ClassHeadTeacherExample;
import com.primary.bean.Classes;
import com.primary.bean.ClassesExample;
import com.primary.bean.ClassesExample.Criteria;
import com.primary.service.ClassDetailService;
import com.primary.service.ClassHeadTeacherService;
import com.primary.service.ClassesService;
import com.primary.util.CheckUtil;
import com.primary.util.JSONUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="class")
public class ClassController {
	@Resource
	private ClassesService classesService;
	@Resource
	private ClassHeadTeacherService classHeadTeacherService;
	@Resource
	private ClassDetailService classDetailService;
	
	@RequestMapping(value="/findClassWithTeachers")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	@ResponseBody
	public String findClassWithTeachers(Integer page, Integer rows, String classname, Integer gradeid, Integer classid) {
		ClassesExample example = new ClassesExample();
		
		Criteria criteria = example.createCriteria();
		
		if (gradeid != null) {
			criteria.andGradeidEqualTo(gradeid);
		}
		
		if (classname != null && classname.length() > 0) {
			criteria.andClassnameLike("%" + classname + "%");
		}
		
		if (classid != null) {
			criteria.andClassidEqualTo(classid);
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<Classes> classess = classesService.selectByExample(example);
		
		List<List<String>> teacherLists = new ArrayList<List<String>>();
		
		for (Classes classes : classess) {
			ClassHeadTeacherExample classHeadTeacherExample = new ClassHeadTeacherExample();
			
			classHeadTeacherExample.createCriteria().andClassidEqualTo(classes.getClassid());
			
			List<ClassHeadTeacher> classHeadTeachers = classHeadTeacherService.selectByExample(classHeadTeacherExample);
			
			List<String> factor = new ArrayList<String>();
			for (ClassHeadTeacher classHeadTeacher : classHeadTeachers) {
				factor.add(classHeadTeacher.getName());
			}
			
			teacherLists.add(factor);
		}
		
		JSONArray array = JSONUtil.addListCol(classess, teacherLists, "stuffnames");
		
		JSONObject result = new JSONObject();
		
		result.put("total", classesService.countByExample(example));
		result.put("rows", array);
		
		return result.toString();
	}
	
	@RequestMapping(value="/findClassWithDetail")
	@RequestPermission(role=RequestPermissionParser.role_stuff, isStrict=true)
	@ResponseBody
	public String findClassWithDetail(Integer page, Integer rows, Integer stuffid, String sessnname, String gradename, String classname, Integer classid) {
		ClassDetailExample example = new ClassDetailExample();
		
		com.primary.bean.ClassDetailExample.Criteria criteria = example.createCriteria();
		
		if (sessnname != null && sessnname.length() > 0) {
			criteria.andSessnnameLike("%" + sessnname + "%");
		}
		
		if (gradename != null && gradename.length() > 0) {
			criteria.andGradenameLike("%" + gradename + "%");
		}
		
		if (classname != null && classname.length() > 0) {
			criteria.andClassnameLike("%" + classname + "%");
		}
		
		if (classid != null) {
			criteria.andClassidEqualTo(classid);
		}
		
		if (stuffid != null) {
			ClassHeadTeacherExample tExample = new ClassHeadTeacherExample();
			tExample.createCriteria().andStuffidEqualTo(stuffid);
			List<ClassHeadTeacher> list = classHeadTeacherService.selectByExample(tExample);
			List<Integer> classids = new ArrayList<Integer>();
			for (ClassHeadTeacher t : list) {
				classids.add(t.getClassid());
			}
			criteria.andClassidIn(classids);
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<ClassDetail> classDetails = classDetailService.selectByExample(example);
	
		JSONArray array = new JSONArray(classDetails);
		
		JSONObject result = new JSONObject();
		
		result.put("total", classDetailService.countByExample(example));
		result.put("rows", array);
		
		return result.toString();
	}
	
	
	@RequestMapping(value="/classAdd")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	@ResponseBody
	public String classAdd(String classname, Integer gradeid, Integer classid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(gradeid, classname, classid) || classname.length() < 1) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		ClassesExample example = new ClassesExample();
		example.createCriteria().andClassidEqualTo(classid);
		if (classesService.countByExample(example) > 0) {
			result.put("message", "添加失败,存在重复数据");
			
			return result.toString();
		}
		
		classesService.insert(new Classes(classid, classname, gradeid));
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/classDelete")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String classDelete(Integer classid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(classid)) {
			result.put("message", "删除失败,存在非法数据");
			
			return result.toString();
		}
		
		if (classesService.selectByPrimaryKey(classid) == null) {
			result.put("message", "删除失败,不存在该记录");
			
			return result.toString();
		}
		
		classesService.deleteByPrimaryKey(classid);
		
		result.put("message", "删除成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/classUpdate")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String classUpdate(String classname, Integer gradeid, Integer classid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(gradeid, classname, classid) || classname.length() < 1) {
			result.put("message", "更新失败,存在非法数据");
			
			return result.toString();
		}
		
		if (classesService.selectByPrimaryKey(classid) == null) {
			result.put("message", "修改失败,没有id为" + classid + "的数据");
			
			return result.toString();
		}
		
		classesService.updateByPrimaryKeySelective(new Classes(classid, classname, gradeid));
		
		result.put("message", "修改成功");
		
		return result.toString();
	}
}

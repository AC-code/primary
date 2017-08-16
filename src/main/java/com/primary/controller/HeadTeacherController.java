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
import com.primary.bean.ClassHeadTeacher;
import com.primary.bean.ClassHeadTeacherExample;
import com.primary.bean.ClassHeadTeacherExample.Criteria;
import com.primary.bean.HeadTeacherExample;
import com.primary.bean.HeadTeacherKey;
import com.primary.service.ClassHeadTeacherService;
import com.primary.service.HeadTeacherService;
import com.primary.util.CheckUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="/headTeacher")
@RequestPermission(role=RequestPermissionParser.role_stuff)
public class HeadTeacherController {
	@Resource
	private HeadTeacherService headTeacherService;
	@Resource
	private ClassHeadTeacherService classHeadTeacherService;
	
	@RequestMapping(value="/findHeadTeacher")
	@ResponseBody
	public String findHeadTeacher(Integer page, Integer rows, String name, Integer stuffid, Integer classid) {
		ClassHeadTeacherExample example = new ClassHeadTeacherExample();
		
		Criteria criteria = example.createCriteria();
		
		if (classid != null) {
			criteria.andClassidEqualTo(classid);
		}
		if (stuffid != null) {
			criteria.andStuffidEqualTo(stuffid);
		}
		
		if (name != null && name.length() > 0) {
			criteria.andNameLike("%" + name + "%");
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<ClassHeadTeacher> classHeadTeachers = classHeadTeacherService.selectByExample(example);
		
		JSONObject result = new JSONObject();
		
		Log.info(classHeadTeachers);
		
		result.put("total", classHeadTeacherService.countByExample(example));
		result.put("rows", new JSONArray(classHeadTeachers));
		
		return result.toString();
	}
	
	@RequestMapping(value="/addHeadTeacher")
	@ResponseBody
	public String addHeadTeacher(Integer classid, Integer stuffid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(classid, stuffid)) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		HeadTeacherExample example = new HeadTeacherExample();
		example.createCriteria().andClassidEqualTo(classid).andStuffidEqualTo(stuffid);
		if (headTeacherService.countByExample(example) > 0) {
			result.put("message", "添加失败,存在重复数据");
			
			return result.toString();
		}
		
		headTeacherService.insert(new HeadTeacherKey(classid, stuffid));
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@RequestMapping(value="/removeHeadTeacher")
	@ResponseBody
	public String removeHeadTeacher(Integer classid, Integer stuffid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(classid, stuffid)) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		headTeacherService.deleteByPrimaryKey(new HeadTeacherKey(classid, stuffid));
		
		result.put("message", "移除成功");
		
		return result.toString();
	}
}

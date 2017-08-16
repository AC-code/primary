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
import com.primary.bean.Stuff;
import com.primary.bean.StuffExample;
import com.primary.bean.StuffExample.Criteria;
import com.primary.service.StuffService;
import com.primary.util.CheckUtil;
import com.primary.util.Log;

@Controller
@RequestPermission(role=RequestPermissionParser.role_admin)
public class StuffController {
	@Resource
	private StuffService stuffService;
	
	@RequestMapping(value="/stuff/stuffMain")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String pageStuffMain() {
		return "/stuff/stuffMain";
	}
	
	@RequestMapping(value="/stuff/admin/stuffMana")
	public String pagestuffMana() {
		return "/stuff/admin/stuffMana";
	}
	
	@RequestMapping(value="/stuff/student/stuMana")
	public String pagestuMana() {
		return "/stuff/student/stuMana";
	}
	
	@RequestMapping(value="/stuff/parent/parentMana")
	public String parentMana() {
		return "/stuff/parent/parentMana";
	}
	
	@RequestMapping(value="/stuff/course/courseMana")
	public String courseMana() {
		return "/stuff/course/courseMana";
	}
	
	@RequestMapping(value="/stuff/course/myCourse")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String myCourse() {
		return "/stuff/course/myCourse";
	}
	
	@RequestMapping(value="/stuff/student/lotStu")
	public String pageLotStu() {
		return "/stuff/student/lotStu";
	}
	
	@RequestMapping(value="/stuff/session/sessionMana")
	public String sessionMana() {
		return "/stuff/session/sessionMana";
	}
	
	@RequestMapping(value="/stuff/session/sessionGrade")
	public String sessionGrade() {
		return "/stuff/session/sessionGrade";
	}
	
	@RequestMapping(value="/stuff/grade/gradeMana")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String gradeMana() {
		return "/stuff/grade/gradeMana";
	}
	
	@RequestMapping(value="/stuff/grade/gradeCourseMana")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String gradeCourseMana() {
		return "/stuff/grade/gradeCourseMana";
	}
	
	@RequestMapping(value="/stuff/class/classMana")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String classMana() {
		return "/stuff/class/classMana";
	}
	
	@RequestMapping(value="/stuff/class/classCourseTeacherMana")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String classCourseTeacherMana() {
		return "/stuff/class/classCourseTeacherMana";
	}
	
	@RequestMapping(value="/stuff/findStuff")
	@ResponseBody
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String findStuff(Integer page, Integer rows, Integer stuffid, String name, Integer authority) {
		StuffExample stuffExample = new StuffExample();

		//构造查询条件
		Criteria criteria = stuffExample.createCriteria();
		if (stuffid != null) {
			Log.info(stuffid);
			criteria.andStuffidEqualTo(stuffid);
		}
		if (name != null && name.length() > 0) {
			Log.info(name);
			criteria.andNameLike("%" + name + "%");
		}
		if (authority != null) {
			Log.info(authority);
			criteria.andAuthorityEqualTo(authority);
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<Stuff> stuffs = stuffService.selectByExample(stuffExample);
		
		JSONArray array = new JSONArray();
		
		for (Stuff stuff : stuffs) {
			array.put(new JSONObject(stuff));
		}
		
		Log.info(array);
		
		JSONObject result = new JSONObject();
		
		result.put("total", stuffService.countByExample(stuffExample));
		result.put("rows", array);
		
		return result.toString();
	}
	
	@RequestMapping(value="/stuff/stuffAdd")
	@ResponseBody
	public String stuffAdd(Integer stuffid, String name, String password, Integer authority) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(stuffid, name, password, authority)) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		stuffService.insert(new Stuff(stuffid, authority, name, password));
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@RequestMapping(value="/stuff/stuffUpdate")
	@RequestPermission(role=RequestPermissionParser.role_stuff, isStrict=true)
	@ResponseBody
	public String stuffUpdate(Integer stuffid, String name, String password, Integer authority) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(stuffid, name, password, authority)) {
			result.put("message", "修改失败,存在非法数据");
			
			return result.toString();
		}
		
		stuffService.updateByPrimaryKey(new Stuff(stuffid, authority, name, password));
		
		result.put("message", "修改成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/stuff/stuffDelete")
	public String stuffDelete(Integer stuffid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(stuffid)) {
			result.put("message", "删除失败,存在非法数据");
			
			return result.toString();
		}
		
		stuffService.deleteByPrimaryKey(stuffid);
		
		result.put("message", "删除成功");
		
		return result.toString();
	}
}

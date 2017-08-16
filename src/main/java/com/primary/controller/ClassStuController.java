package com.primary.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primary.annotation.RequestPermission;
import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.bean.ClassStu;
import com.primary.bean.ClassStuDetail;
import com.primary.bean.ClassStuKey;
import com.primary.service.ClassStuDetailService;
import com.primary.service.ClassStuService;
import com.primary.util.CheckUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="/classStu")
@RequestPermission(role=RequestPermissionParser.role_stuff)
public class ClassStuController {
	@Resource
	private ClassStuDetailService classStuDetailService;
	@Resource
	private ClassStuService classStuService;
	
	@ResponseBody
	@RequestMapping(value="/findClassStudent")
	public String findClassStudent(Integer page, Integer rows, Integer classid, Integer stuid, String stuname, Integer number) {
		
		Map queryData = classStuDetailService.selectByParams(page, rows, classid, stuid, stuname, number);
		
		List<ClassStuDetail> datas = (List<ClassStuDetail>) queryData.get("data");
		
		JSONArray array = new JSONArray(datas);
		
		Log.info(array);
		
		JSONObject result = new JSONObject();
		
		result.put("total", queryData.get("total"));
		
		result.put("rows", array);
		
		Log.info(result);
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/addClassStudent")
	public String addClassStudent(ClassStu stu) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(stu, stu.getClassid(), stu.getNumber(), stu.getStuid())) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		if (classStuService.selectByPrimaryKey(new ClassStuKey(stu.getNumber(), stu.getClassid())) != null) {
			result.put("message", "添加失败,id冲突");
			
			return result.toString();
		}
		
		classStuService.insert(stu);
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteClassStudent")
	public String deleteClassStudent(Integer number, Integer classid) {
		JSONObject result = new JSONObject();
		if (CheckUtil.nullCheck(number, classid)) {
			
			result.put("message", "删除失败,存在非法数据");
			
			return result.toString();
		}
		
		classStuService.deleteByPrimaryKey(new ClassStuKey(number, classid));
		
		result.put("message", "删除成功");
		
		return result.toString();
	}
}

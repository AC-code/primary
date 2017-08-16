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
import com.primary.bean.Parent;
import com.primary.bean.Student;
import com.primary.bean.StudentParent;
import com.primary.bean.StudentParentExample;
import com.primary.bean.StudentParentExample.Criteria;
import com.primary.service.ParentService;
import com.primary.service.StuParService;
import com.primary.util.CheckUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="/parent")
@RequestPermission(role=RequestPermissionParser.role_admin)
public class ParentController {
	@Resource
	private StuParService stuParService;
	@Resource
	private ParentService parentService;

	@RequestMapping(value="/parentMain")
	@RequestPermission(role=RequestPermissionParser.role_parent)
	public String parentMain() {
		return "/parent/parentMain";
	}
	
	@ResponseBody
	@RequestMapping(value="/findParent")
	public String findParent(Integer page, Integer rows, String stuname) {
		StudentParentExample stuParExample = new StudentParentExample();
		
		//构造查询条件
		Criteria criteria = stuParExample.createCriteria();
		if (stuname != null && stuname.length() > 0) {
			criteria.andStunameLike("%" + stuname + "%");
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<StudentParent> stuPars = stuParService.selectByExample(stuParExample);
		
		JSONArray array = new JSONArray();
		
		for (StudentParent stuPar : stuPars) {
			array.put(new JSONObject(stuPar));
		}
		
		Log.info(array);
		
		JSONObject result = new JSONObject();
		
		result.put("total", stuParService.countByExample(stuParExample));
		result.put("rows", array);
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/parentUpdate")
	@RequestPermission(role=RequestPermissionParser.role_parent, isStrict=true)
	public String parentUpdate(Integer parentid, String password) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(password) || password.length() < 1) {
			result.put("message", "修改失败,存在非法数据");
			
			return result.toString();
		}
		
		parentService.updateByPrimaryKeySelective(new Parent(parentid, null, password));
		
		result.put("message", "修改成功");
		
		return result.toString();
	}
}

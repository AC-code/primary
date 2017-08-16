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
import com.primary.bean.Session;
import com.primary.bean.SessionExample;
import com.primary.bean.SessionExample.Criteria;
import com.primary.service.SessionService;
import com.primary.util.CheckUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="/session")
@RequestPermission(role=RequestPermissionParser.role_admin)
public class SessionController {
	@Resource
	private SessionService sessionService;
	
	@ResponseBody
	@RequestMapping(value="/findSession")
	public String findStudent(Integer page, Integer rows, Integer sessnid, String sessnname) {
		SessionExample sessionExample = new SessionExample();
		
		//构造查询条件
		Criteria criteria = sessionExample.createCriteria();
		if (sessnid != null) {
			criteria.andSessnidEqualTo(sessnid);
		}
		if (sessnname != null && sessnname.length() > 0) {
			criteria.andSessnnameLike("%" + sessnname + "%");
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<Session> sessions = sessionService.selectByExample(sessionExample);
		
		JSONArray array = new JSONArray(sessions);
		
		Log.info(array);
		
		JSONObject result = new JSONObject();
		
		result.put("total", sessionService.countByExample(sessionExample));
		result.put("rows", array);
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/sessionAdd")
	public String studentAdd(Integer sessnid, String sessnname) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(sessnid, sessnname) || sessnname.length() < 1) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		if (sessionService.selectByPrimaryKey(sessnid) != null) {
			result.put("message", "添加失败,id冲突");
			
			return result.toString();
		}
		
		sessionService.insert(new Session(sessnid, sessnname));
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/sessionDelete")
	public String studentDelete(Integer sessnid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(sessnid)) {
			result.put("message", "删除失败,存在非法数据");
			
			return result.toString();
		}
		
		sessionService.deleteByPrimaryKey(sessnid);
		
		result.put("message", "删除成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/sessionUpdate")
	public String studentUpdate(Integer sessnid, String sessnname) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(sessnid, sessnname) || sessnname.length() < 1) {
			result.put("message", "修改失败,存在非法数据");
			
			return result.toString();
		}
		
		if (sessionService.selectByPrimaryKey(sessnid) == null) {
			result.put("message", "修改失败,没有id为" + sessnid + "的数据");
			
			return result.toString();
		}
		
		sessionService.updateByPrimaryKeySelective(new Session(sessnid, sessnname));
		
		result.put("message", "修改成功");
		
		return result.toString();
	}
}

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
import com.primary.bean.GradePrefect;
import com.primary.bean.GradePrefectExample;
import com.primary.bean.GradePrefectExample.Criteria;
import com.primary.bean.PrefectExample;
import com.primary.bean.PrefectKey;
import com.primary.service.GradePrefectService;
import com.primary.service.PrefectKeyService;
import com.primary.util.CheckUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="prefect")
@RequestPermission(role=RequestPermissionParser.role_admin)
public class PrefectController {
	@Resource
	private PrefectKeyService prefectKeyService;
	@Resource
	private GradePrefectService gradePrefectService;
	
	@RequestMapping(value="/findPrefect")
	@ResponseBody
	@RequestPermission(role=RequestPermissionParser.role_stuff, isStrict=true)
	public String findPrefect(Integer page, Integer rows, String name, Integer gradeid, Integer stuffid, String gradename, String sessnname) {
		GradePrefectExample example = new GradePrefectExample();
		
		Criteria criteria = example.createCriteria();
		
		if (gradeid != null) {
			criteria.andGradeidEqualTo(gradeid);
		}
		
		if (stuffid != null) {
			criteria.andStuffidEqualTo(stuffid);
		}
		
		if (name != null && name.length() > 0) {
			criteria.andNameLike("%" + name + "%");
		}
		
		if (gradename != null && gradename.length() > 0) {
			criteria.andGradenameLike("%" + gradename + "%");
		}
		
		if (sessnname != null && sessnname.length() > 0) {
			criteria.andSessnnameLike("%" + sessnname + "%");
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<GradePrefect> gradePrefects = gradePrefectService.selectByExample(example);
		
		JSONObject result = new JSONObject();
		
		Log.info(gradePrefects);
		
		result.put("total", gradePrefectService.countByExample(example));
		result.put("rows", new JSONArray(gradePrefects));
		
		return result.toString();
	}
	
	@RequestMapping(value="/addPrefecet")
	@ResponseBody
	public String addPrefecet(Integer gradeid, Integer stuffid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(gradeid, stuffid)) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		PrefectExample example = new PrefectExample();
		example.createCriteria().andGradeidEqualTo(gradeid).andStuffidEqualTo(stuffid);
		if (prefectKeyService.countByExample(example) > 0) {
			result.put("message", "添加失败,存在重复数据");
			
			return result.toString();
		}
		
		prefectKeyService.insert(new PrefectKey(stuffid, gradeid));
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@RequestMapping(value="/removePrefect")
	@ResponseBody
	public String removePrefect(Integer gradeid, Integer stuffid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(gradeid, stuffid)) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		prefectKeyService.deleteByPrimaryKey(new PrefectKey(stuffid, gradeid));
		
		result.put("message", "移除成功");
		
		return result.toString();
	}
}

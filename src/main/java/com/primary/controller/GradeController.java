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
import com.primary.bean.Grade;
import com.primary.bean.GradeExample;
import com.primary.bean.GradeExample.Criteria;
import com.primary.bean.GradePrefect;
import com.primary.bean.GradePrefectExample;
import com.primary.service.GradePrefectService;
import com.primary.service.GradeService;
import com.primary.util.CheckUtil;
import com.primary.util.JSONUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="grade")
@RequestPermission(role=RequestPermissionParser.role_admin)
public class GradeController {
	@Resource
	private GradeService gradeService;
	@Resource
	private GradePrefectService gradePrefectService;
	
	@ResponseBody
	@RequestMapping(value="/findGrade")
	public String findStudent(Integer page, Integer rows, Integer gradeid, String gradename, Integer sessnid) {
		GradeExample gradeExample = new GradeExample();
		
		//构造查询条件
		Criteria criteria = gradeExample.createCriteria();
		if (gradeid != null) {
			criteria.andGradeidEqualTo(gradeid);
		}
		if (sessnid != null) {
			criteria.andSessnidEqualTo(sessnid);
		}
		if (gradename != null && gradename.length() > 0) {
			criteria.andGradenameLike("%" + gradename + "%");
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<Grade> grades = gradeService.selectByExample(gradeExample);
		
		List<List<String>> teacherLists = new ArrayList<List<String>>();
		
		for (Grade grade : grades) {
			GradePrefectExample gradePrefectExample = new GradePrefectExample();
			
			gradePrefectExample.createCriteria().andGradeidEqualTo(grade.getGradeid());
			
			List<GradePrefect> gradePrefects = gradePrefectService.selectByExample(gradePrefectExample);
			
			List<String> factor = new ArrayList<String>();
			for (GradePrefect gradePrefect : gradePrefects) {
				factor.add(gradePrefect.getName());
			}
			
			teacherLists.add(factor);
		}
		
		JSONArray array = JSONUtil.addListCol(grades, teacherLists, "stuffnames");
		
		Log.info(array);
		
		JSONObject result = new JSONObject();
		
		result.put("total", gradeService.countByExample(gradeExample));
		result.put("rows", array);
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/gradeAdd")
	public String studentAdd(Integer gradeid, String gradename, Integer sessnid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(sessnid, gradeid, gradename) || gradename.length() < 1) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		if (gradeService.selectByPrimaryKey(gradeid) != null) {
			result.put("message", "添加失败,id冲突");
			
			return result.toString();
		}
		
		gradeService.insert(new Grade(gradeid, gradename, sessnid));
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/gradeDelete")
	public String studentDelete(Integer gradeid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(gradeid)) {
			result.put("message", "删除失败,存在非法数据");
			
			return result.toString();
		}
		
		gradeService.deleteByPrimaryKey(gradeid);
		
		result.put("message", "删除成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/gradeUpdate")
	public String studentUpdate(Integer gradeid, String gradename) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(gradeid, gradename) || gradename.length() < 1) {
			result.put("message", "修改失败,存在非法数据");
			
			return result.toString();
		}
		
		if (gradeService.selectByPrimaryKey(gradeid) == null) {
			result.put("message", "修改失败,没有id为" + gradeid + "的数据");
			
			return result.toString();
		}
		
		gradeService.updateByPrimaryKeySelective(new Grade(gradeid, gradename, null));
		
		result.put("message", "修改成功");
		
		return result.toString();
	}
}

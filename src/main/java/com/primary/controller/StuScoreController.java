package com.primary.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.primary.annotation.RequestPermission;
import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.bean.StuScoreDetail;
import com.primary.bean.StuScoreDetailExample;
import com.primary.service.StuScoreDetailService;
import com.primary.util.JSONUtil;
import com.primary.util.Log;

@Controller
@RequestMapping(value="/stuScore")
@RequestPermission(role=RequestPermissionParser.role_student, isStrict=true)
public class StuScoreController {
	@Resource
	private StuScoreDetailService stuScoreDetailService;
	
	@RequestMapping(value="/findScore")
	@ResponseBody
	@RequestPermission(role=RequestPermissionParser.role_parent, isStrict=true)
	public String findScore(Integer page, Integer rows, Integer stuid, Integer classid, Integer number, Float mark, String name, String coursename, String classname, String gradename, String sessnname) {
		if (stuid == null) {
			return JSONUtil.getJsonObj("message", "参数出错");
		}
		
		StuScoreDetail stuScoreDetail = new StuScoreDetail();
		stuScoreDetail.setClassid(classid);
		stuScoreDetail.setClassname(classname);
		stuScoreDetail.setCoursename(coursename);
		stuScoreDetail.setGradename(gradename);
		stuScoreDetail.setMark(mark);
		stuScoreDetail.setName(name);
		stuScoreDetail.setNumber(number);
		stuScoreDetail.setSessnname(sessnname);
		stuScoreDetail.setStuid(stuid);
		Log.info(stuScoreDetail);
		StuScoreDetailExample example = stuScoreDetailService.createDefaultExample(stuScoreDetail);
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<StuScoreDetail> datas = stuScoreDetailService.selectByExample(example);
		
		Integer total = stuScoreDetailService.countByExample(example);
		
		return JSONUtil.getJSonList(total, datas).toString();
	}
	
}

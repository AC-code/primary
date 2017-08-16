package com.primary.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primary.annotation.RequestPermission;
import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.bean.Score;
import com.primary.bean.ScoreDetail;
import com.primary.bean.ScoreDetailExample;
import com.primary.service.ScoreDetailService;
import com.primary.service.ScoreService;
import com.primary.util.CheckUtil;
import com.primary.util.JSONUtil;

@Controller
@RequestMapping(value="/score")
@RequestPermission(role=RequestPermissionParser.role_stuff)
public class ScoreController {
	@Resource
	private ScoreDetailService scoreDetailService;
	@Resource
	private ScoreService scoreService;
	
	@ResponseBody
	@RequestMapping(value="/findScore")
	public String findScore(Integer id) {
		if (id == null) {
			return JSONUtil.getJsonObj("message", "查找参数非法");
		}
		
		ScoreDetail scoreDetail = new ScoreDetail();
		scoreDetail.setId(id);
		ScoreDetailExample example = scoreDetailService.createDefaultExample(scoreDetail);
		int total = scoreDetailService.countByExample(example);
		
		if (total == 0) {
			scoreService.createScores(id);
			total = scoreDetailService.countByExample(scoreDetailService.createDefaultExample(scoreDetail));
		}
		
		List<ScoreDetail> list = scoreDetailService.selectByExample(example);
		
		return JSONUtil.getJSonList(total, list).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/updateScore")
	public String updateScore(Float mark, Integer id, Integer number, Integer classid) {
		if (CheckUtil.nullCheck(mark, id, number, classid)) {
			return JSONUtil.getJsonObj("message", "参数出错");
		}
		
		Score score = new Score();
		score.setClassid(classid);
		score.setId(id);
		score.setMark(mark);
		score.setNumber(number);
		
		if (scoreService.selectByPrimaryKey(score) == null) {
			return JSONUtil.getJsonObj("message", "不存在该数据");
		}
		
		scoreService.updateByPrimaryKeySelective(score);
		
		return JSONUtil.getJsonObj("message", "success");
	}
}

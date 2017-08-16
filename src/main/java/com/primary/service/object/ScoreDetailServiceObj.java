package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.primary.bean.ScoreDetail;
import com.primary.bean.ScoreDetailExample;
import com.primary.bean.ScoreDetailExample.Criteria;
import com.primary.dao.ScoreDetailMapper;
import com.primary.service.ScoreDetailService;
import com.primary.util.SQLUtil;

@Service
public class ScoreDetailServiceObj implements ScoreDetailService {
	@Resource
	private ScoreDetailMapper scoreDetailMapper;
	
	@Override
	public int countByExample(ScoreDetailExample example) {
		return scoreDetailMapper.countByExample(example);
	}

	@Override
	public List<ScoreDetail> selectByExample(ScoreDetailExample example) {
		return scoreDetailMapper.selectByExample(example);
	}

	@Override
	public ScoreDetailExample createDefaultExample(ScoreDetail scoreDetail) {
		ScoreDetailExample example = new ScoreDetailExample();
		
		Criteria criteria = example.createCriteria();
		
		if (scoreDetail == null) {
			return example;
		}
		
		if (!StringUtils.isEmpty(scoreDetail.getStuname())) {
			criteria.andStunameLike(SQLUtil.toLike(scoreDetail.getStuname()));
		}
		
		if (scoreDetail.getStuid() != null) {
			criteria.andStuidEqualTo(scoreDetail.getStuid());
		}
		
		if (scoreDetail.getMark() != null) {
			criteria.andMarkEqualTo(scoreDetail.getMark());
		}
		
		if (scoreDetail.getId() != null) {
			criteria.andIdEqualTo(scoreDetail.getId());
		}
		
		if (scoreDetail.getClassid() != null) {
			criteria.andClassidEqualTo(scoreDetail.getClassid());
		}
		
		if (scoreDetail.getNumber() != null) {
			criteria.andNumberEqualTo(scoreDetail.getNumber());
		}
		return example;
	}

}

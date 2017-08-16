package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.primary.bean.StuScoreDetail;
import com.primary.bean.StuScoreDetailExample;
import com.primary.bean.StuScoreDetailExample.Criteria;
import com.primary.dao.StuScoreDetailMapper;
import com.primary.service.StuScoreDetailService;
import com.primary.util.SQLUtil;

@Service
public class StuScoreDetailServiceObj implements StuScoreDetailService {
	@Resource
	private StuScoreDetailMapper stuScoreDetailMapper;
	
	@Override
	public int countByExample(StuScoreDetailExample example) {
		return stuScoreDetailMapper.countByExample(example);
	}

	@Override
	public List<StuScoreDetail> selectByExample(StuScoreDetailExample example) {
		return stuScoreDetailMapper.selectByExample(example);
	}

	@Override
	public StuScoreDetailExample createDefaultExample(StuScoreDetail stuScoreDetail) {
		StuScoreDetailExample example = new StuScoreDetailExample();
		
		Criteria criteria = example.createCriteria();
		
		if (stuScoreDetail == null) {
			return null;
		}
		
		if (stuScoreDetail.getStuid() != null) {
			criteria.andStuidEqualTo(stuScoreDetail.getStuid());
		}
		
		if (stuScoreDetail.getClassid() != null) {
			criteria.andClassidEqualTo(stuScoreDetail.getClassid());
		}
		
		if (stuScoreDetail.getNumber() != null) {
			criteria.andNumberEqualTo(stuScoreDetail.getNumber());
		}
		
		if (stuScoreDetail.getMark() != null) {
			criteria.andMarkEqualTo(stuScoreDetail.getMark());
		}
		
		if (!StringUtils.isEmpty(stuScoreDetail.getName())) {
			criteria.andNameLike(SQLUtil.toLike(stuScoreDetail.getName()));
		}
		
		if (!StringUtils.isEmpty(stuScoreDetail.getCoursename())) {
			criteria.andCoursenameLike(SQLUtil.toLike(stuScoreDetail.getCoursename()));
		}
		
		if (!StringUtils.isEmpty(stuScoreDetail.getClassname())) {
			criteria.andClassnameLike(SQLUtil.toLike(stuScoreDetail.getClassname()));
		}
		
		if (!StringUtils.isEmpty(stuScoreDetail.getGradename())) {
			criteria.andGradenameLike(SQLUtil.toLike(stuScoreDetail.getGradename()));
		}
		
		if (!StringUtils.isEmpty(stuScoreDetail.getSessnname())) {
			criteria.andSessnnameLike(SQLUtil.toLike(stuScoreDetail.getSessnname()));
		}
		
		return example;
	}

}

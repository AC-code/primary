package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.GradePrefect;
import com.primary.bean.GradePrefectExample;
import com.primary.dao.GradePrefectMapper;
import com.primary.service.GradePrefectService;

@Service
public class GradePrefectServiceObj implements GradePrefectService {
	@Resource
	private GradePrefectMapper gradePrefectMapper;
	
	@Override
	public int countByExample(GradePrefectExample example) {
		return gradePrefectMapper.countByExample(example);
	}

	@Override
	public List<GradePrefect> selectByExample(GradePrefectExample example) {
		return gradePrefectMapper.selectByExample(example);
	}

}

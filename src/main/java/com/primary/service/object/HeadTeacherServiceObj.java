package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.HeadTeacherExample;
import com.primary.bean.HeadTeacherKey;
import com.primary.dao.HeadTeacherMapper;
import com.primary.service.HeadTeacherService;

@Service
public class HeadTeacherServiceObj implements HeadTeacherService {
	@Resource
	private HeadTeacherMapper headTeacherMapper;
	
	@Override
	public int countByExample(HeadTeacherExample example) {
		return headTeacherMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(HeadTeacherExample example) {
		return headTeacherMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(HeadTeacherKey key) {
		return headTeacherMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(HeadTeacherKey record) {
		return headTeacherMapper.insert(record);
	}

	@Override
	public int insertSelective(HeadTeacherKey record) {
		return headTeacherMapper.insertSelective(record);
	}

	@Override
	public List<HeadTeacherKey> selectByExample(HeadTeacherExample example) {
		return headTeacherMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(HeadTeacherKey record, HeadTeacherExample example) {
		return headTeacherMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(HeadTeacherKey record, HeadTeacherExample example) {
		return headTeacherMapper.updateByExample(record, example);
	}

}

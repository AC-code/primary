package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.Grade;
import com.primary.bean.GradeExample;
import com.primary.dao.GradeMapper;
import com.primary.service.GradeService;

@Service
public class GradeServiceObj implements GradeService {
	@Resource
	private GradeMapper gradeMapper;
	
	@Override
	public int countByExample(GradeExample example) {
		return gradeMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(GradeExample example) {
		return gradeMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer gradeid) {
		return gradeMapper.deleteByPrimaryKey(gradeid);
	}

	@Override
	public int insert(Grade record) {
		return gradeMapper.insert(record);
	}

	@Override
	public int insertSelective(Grade record) {
		return gradeMapper.insertSelective(record);
	}

	@Override
	public List<Grade> selectByExample(GradeExample example) {
		return gradeMapper.selectByExample(example);
	}

	@Override
	public Grade selectByPrimaryKey(Integer gradeid) {
		return gradeMapper.selectByPrimaryKey(gradeid);
	}

	@Override
	public int updateByExampleSelective(Grade record, GradeExample example) {
		return gradeMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Grade record, GradeExample example) {
		return gradeMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Grade record) {
		return gradeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Grade record) {
		return gradeMapper.updateByPrimaryKey(record);
	}

}

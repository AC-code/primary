package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.ClassStu;
import com.primary.bean.ClassStuExample;
import com.primary.bean.ClassStuKey;
import com.primary.dao.ClassStuMapper;
import com.primary.service.ClassStuService;

@Service
public class ClassStuServiceObj implements ClassStuService {
	@Resource
	private ClassStuMapper classStuMapper;
	
	@Override
	public int countByExample(ClassStuExample example) {
		return classStuMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ClassStuExample example) {
		return classStuMapper.deleteByExample(example);
	}


	@Override
	public int insert(ClassStu record) {
		return classStuMapper.insert(record);
	}

	@Override
	public int insertSelective(ClassStu record) {
		return classStuMapper.insertSelective(record);
	}

	@Override
	public List<ClassStu> selectByExample(ClassStuExample example) {
		return classStuMapper.selectByExample(example);
	}


	@Override
	public int updateByExampleSelective(ClassStu record, ClassStuExample example) {
		return classStuMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ClassStu record, ClassStuExample example) {
		return classStuMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ClassStu record) {
		return classStuMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ClassStu record) {
		return classStuMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(ClassStuKey key) {
		return classStuMapper.deleteByPrimaryKey(key);
	}

	@Override
	public ClassStu selectByPrimaryKey(ClassStuKey key) {
		return classStuMapper.selectByPrimaryKey(key);
	}

}

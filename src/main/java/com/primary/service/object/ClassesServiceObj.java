package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.Classes;
import com.primary.bean.ClassesExample;
import com.primary.dao.ClassesMapper;
import com.primary.service.ClassesService;

@Service
public class ClassesServiceObj implements ClassesService {
	@Resource
	private ClassesMapper classesMapper;
	
	@Override
	public int countByExample(ClassesExample example) {
		return classesMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ClassesExample example) {
		return classesMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer classid) {
		return classesMapper.deleteByPrimaryKey(classid);
	}

	@Override
	public int insert(Classes record) {
		return classesMapper.insert(record);
	}

	@Override
	public int insertSelective(Classes record) {
		return classesMapper.insertSelective(record);
	}

	@Override
	public List<Classes> selectByExample(ClassesExample example) {
		return classesMapper.selectByExample(example);
	}

	@Override
	public Classes selectByPrimaryKey(Integer classid) {
		return classesMapper.selectByPrimaryKey(classid);
	}

	@Override
	public int updateByExampleSelective(Classes record, ClassesExample example) {
		return classesMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Classes record, ClassesExample example) {
		return classesMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Classes record) {
		return classesMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Classes record) {
		return classesMapper.updateByPrimaryKey(record);
	}

}

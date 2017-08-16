package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.ClassHeadTeacher;
import com.primary.bean.ClassHeadTeacherExample;
import com.primary.dao.ClassHeadTeacherMapper;
import com.primary.service.ClassHeadTeacherService;

@Service
public class ClassHeadTeacherServiceObj implements ClassHeadTeacherService {
	@Resource
	private ClassHeadTeacherMapper classHeadTeacherMapper;
	
	@Override
	public int countByExample(ClassHeadTeacherExample example) {
		return classHeadTeacherMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ClassHeadTeacherExample example) {
		return classHeadTeacherMapper.deleteByExample(example);
	}

	@Override
	public int insert(ClassHeadTeacher record) {
		return classHeadTeacherMapper.insert(record);
	}

	@Override
	public int insertSelective(ClassHeadTeacher record) {
		return classHeadTeacherMapper.insertSelective(record);
	}

	@Override
	public List<ClassHeadTeacher> selectByExample(ClassHeadTeacherExample example) {
		return classHeadTeacherMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(ClassHeadTeacher record, ClassHeadTeacherExample example) {
		return classHeadTeacherMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ClassHeadTeacher record, ClassHeadTeacherExample example) {
		return classHeadTeacherMapper.updateByExample(record, example);
	}

}

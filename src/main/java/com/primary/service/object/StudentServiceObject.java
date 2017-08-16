package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.Parent;
import com.primary.bean.Student;
import com.primary.bean.StudentExample;
import com.primary.bean.StudentExample.Criteria;
import com.primary.dao.StudentMapper;
import com.primary.service.ParentService;
import com.primary.service.StudentService;

@Service
public class StudentServiceObject implements StudentService {
	@Resource
	private StudentMapper studentMapper;
	@Resource
	private ParentService parentService;
	
	@Override
	public int countByExample(StudentExample example) {
		return studentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(StudentExample example) {
		return studentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer stuid) {
		return studentMapper.deleteByPrimaryKey(stuid);
	}

	@Override
	public int insert(Student record) {
		return studentMapper.insert(record);
	}

	@Override
	public int insertSelective(Student record) {
		return studentMapper.insertSelective(record);
	}

	@Override
	public List<Student> selectByExample(StudentExample example) {
		return studentMapper.selectByExample(example);
	}

	@Override
	public Student selectByPrimaryKey(Integer stuid) {
		return studentMapper.selectByPrimaryKey(stuid);
	}

	@Override
	public int updateByExampleSelective(Student record, StudentExample example) {
		return studentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Student record, StudentExample example) {
		return studentMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		return studentMapper.updateByPrimaryKey(record);
	}

	@Override
	public int createStudent(Student record) {
		int result = insert(record);
		
		parentService.insert(new Parent(record.getStuid(), record.getStuid(), record.getStuid().toString()));
		
		return result;
	}

	@Override
	public int removeStudentByPrimaryKey(Integer stuid) {
		parentService.deleteByPrimaryKey(stuid);
		
		return deleteByPrimaryKey(stuid);
	}

	@Override
	public int insert(List<Student> records) {
		
		for (Student record : records) {
			createStudent(record);
		}
		
		return 1;
	}

	@Override
	public StudentExample betweenPrimaryExample(Integer min, Integer max) {
		StudentExample example = new StudentExample();
		
		if (min == null || max == null) {
			return example;
		}
		
		Criteria criteria = example.createCriteria();
		criteria.andStuidBetween(min, max);
		
		return example;
	}
	
}

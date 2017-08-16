package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.StudentParent;
import com.primary.bean.StudentParentExample;
import com.primary.dao.StudentParentMapper;
import com.primary.service.StuParService;

@Service
public class StuParServiceObj implements StuParService {
	@Resource
	private StudentParentMapper stuParMapper;
	
	@Override
	public int countByExample(StudentParentExample example) {
		return stuParMapper.countByExample(example);
	}

	@Override
	public List<StudentParent> selectByExample(StudentParentExample example) {
		return stuParMapper.selectByExample(example);
	}

}

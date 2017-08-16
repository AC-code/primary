package com.primary.service;

import java.util.List;

import com.primary.bean.StudentParent;
import com.primary.bean.StudentParentExample;

public interface StuParService {
	public int countByExample(StudentParentExample example);
	
	public List<StudentParent> selectByExample(StudentParentExample example);
}

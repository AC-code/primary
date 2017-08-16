package com.primary.service;

import java.util.List;

import com.primary.bean.TeacClassCourseGrade;
import com.primary.bean.TeacClassCourseGradeExample;

public interface TeacClassCourseGradeService {
	public int countByExample(TeacClassCourseGradeExample example);
    
    public List<TeacClassCourseGrade> selectByExample(TeacClassCourseGradeExample example);
    
    public TeacClassCourseGradeExample createDefaultExample(TeacClassCourseGrade record);
}

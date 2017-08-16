package com.primary.service;

import java.util.List;

import com.primary.bean.TeacherClassCourseDetail;
import com.primary.bean.TeacherClassCourseDetailExample;

public interface TeacherClassCourseDetailService {
    public int countByExample(TeacherClassCourseDetailExample example);
    
    public List<TeacherClassCourseDetail> selectByExample(TeacherClassCourseDetailExample example);
    
    public TeacherClassCourseDetailExample createDefaultExample(TeacherClassCourseDetail detail);
}

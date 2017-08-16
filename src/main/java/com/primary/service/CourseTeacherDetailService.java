package com.primary.service;

import java.util.List;

import com.primary.bean.CourseTeacherDetail;
import com.primary.bean.CourseTeacherDetailExample;

public interface CourseTeacherDetailService {
    public int countByExample(CourseTeacherDetailExample example);
    
    public List<CourseTeacherDetail> selectByExample(CourseTeacherDetailExample example);
    
    public List<CourseTeacherDetail> selectByParms(String name, Integer stuffid, Integer gCId, Integer classid);
}

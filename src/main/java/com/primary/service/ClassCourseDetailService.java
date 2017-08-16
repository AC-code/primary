package com.primary.service;

import java.util.List;
import java.util.Map;

import com.primary.bean.ClassCourseDetail;
import com.primary.bean.ClassCourseDetailExample;

public interface ClassCourseDetailService {
    public int countByExample(ClassCourseDetailExample example);

    public List<ClassCourseDetail> selectByExample(ClassCourseDetailExample example);
    
    public Map<String, Object> selectByParams(Integer gCId, Integer classid, String coursename);
}

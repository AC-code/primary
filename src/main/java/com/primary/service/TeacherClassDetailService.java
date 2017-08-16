package com.primary.service;

import java.util.List;

import com.primary.bean.TeacherClassDetail;
import com.primary.bean.TeacherClassDetailExample;

public interface TeacherClassDetailService {
    public int countByExample(TeacherClassDetailExample example);
    
    public List<TeacherClassDetail> selectByExample(TeacherClassDetailExample example);
    
    public TeacherClassDetailExample createDefaultExample(TeacherClassDetail detail);
}

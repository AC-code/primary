package com.primary.service;

import java.util.List;
import java.util.Map;

import com.primary.bean.ClassStuDetail;
import com.primary.bean.ClassStuDetailExample;

public interface ClassStuDetailService {
    public int countByExample(ClassStuDetailExample example);

    public List<ClassStuDetail> selectByExample(ClassStuDetailExample example);
    
    public Map<String, Object> selectByParams(Integer page, Integer rows, Integer classid, Integer stuid, String stuname, Integer number);
}

package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.ClassDetail;
import com.primary.bean.ClassDetailExample;

public interface ClassDetailService {
    public int countByExample(ClassDetailExample example);

    public List<ClassDetail> selectByExample(ClassDetailExample example);
}

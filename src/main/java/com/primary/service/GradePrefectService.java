package com.primary.service;

import java.util.List;

import com.primary.bean.GradePrefect;
import com.primary.bean.GradePrefectExample;

public interface GradePrefectService {
    public int countByExample(GradePrefectExample example);
    
    public List<GradePrefect> selectByExample(GradePrefectExample example);
}

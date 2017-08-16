package com.primary.service;

import java.util.List;

import com.primary.bean.ScoreDetail;
import com.primary.bean.ScoreDetailExample;
import com.primary.bean.ScoreExample;

public interface ScoreDetailService {
    public int countByExample(ScoreDetailExample example);
    
    public List<ScoreDetail> selectByExample(ScoreDetailExample example);
    
    public ScoreDetailExample createDefaultExample(ScoreDetail scoreDetail);
}

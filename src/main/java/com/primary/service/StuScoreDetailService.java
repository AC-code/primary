package com.primary.service;

import java.util.List;

import com.primary.bean.StuScoreDetail;
import com.primary.bean.StuScoreDetailExample;

public interface StuScoreDetailService {
    public int countByExample(StuScoreDetailExample example);

    public List<StuScoreDetail> selectByExample(StuScoreDetailExample example);
    
    public StuScoreDetailExample createDefaultExample(StuScoreDetail stuScoreDetail);
}

package com.primary.dao;

import com.primary.bean.StuScoreDetail;
import com.primary.bean.StuScoreDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuScoreDetailMapper {
    int countByExample(StuScoreDetailExample example);

    int deleteByExample(StuScoreDetailExample example);

    int insert(StuScoreDetail record);

    int insertSelective(StuScoreDetail record);

    List<StuScoreDetail> selectByExample(StuScoreDetailExample example);

    int updateByExampleSelective(@Param("record") StuScoreDetail record, @Param("example") StuScoreDetailExample example);

    int updateByExample(@Param("record") StuScoreDetail record, @Param("example") StuScoreDetailExample example);
}
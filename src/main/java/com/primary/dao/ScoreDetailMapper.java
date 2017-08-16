package com.primary.dao;

import com.primary.bean.ScoreDetail;
import com.primary.bean.ScoreDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreDetailMapper {
    int countByExample(ScoreDetailExample example);

    int deleteByExample(ScoreDetailExample example);

    int insert(ScoreDetail record);

    int insertSelective(ScoreDetail record);

    List<ScoreDetail> selectByExample(ScoreDetailExample example);

    int updateByExampleSelective(@Param("record") ScoreDetail record, @Param("example") ScoreDetailExample example);

    int updateByExample(@Param("record") ScoreDetail record, @Param("example") ScoreDetailExample example);
}
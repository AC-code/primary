package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.Score;
import com.primary.bean.ScoreExample;
import com.primary.bean.ScoreKey;

public interface ScoreService {
    public int countByExample(ScoreExample example);

    public int deleteByExample(ScoreExample example);

    public int deleteByPrimaryKey(ScoreKey key);

    public int insert(Score record);

    public int insertSelective(Score record);

    public List<Score> selectByExample(ScoreExample example);

    public Score selectByPrimaryKey(ScoreKey key);

    public int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    public int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    public int updateByPrimaryKeySelective(Score record);

    public int updateByPrimaryKey(Score record);
    
    public void createScores(Integer id);
}

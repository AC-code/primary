package com.primary.dao;

import com.primary.bean.PrefectExample;
import com.primary.bean.PrefectKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrefectMapper {
    int countByExample(PrefectExample example);

    int deleteByExample(PrefectExample example);

    int deleteByPrimaryKey(PrefectKey key);

    int insert(PrefectKey record);

    int insertSelective(PrefectKey record);

    List<PrefectKey> selectByExample(PrefectExample example);

    int updateByExampleSelective(@Param("record") PrefectKey record, @Param("example") PrefectExample example);

    int updateByExample(@Param("record") PrefectKey record, @Param("example") PrefectExample example);
}
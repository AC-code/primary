package com.primary.dao;

import com.primary.bean.PToPExample;
import com.primary.bean.PToPKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PToPMapper {
    int countByExample(PToPExample example);

    int deleteByExample(PToPExample example);

    int deleteByPrimaryKey(PToPKey key);

    int insert(PToPKey record);

    int insertSelective(PToPKey record);

    List<PToPKey> selectByExample(PToPExample example);

    int updateByExampleSelective(@Param("record") PToPKey record, @Param("example") PToPExample example);

    int updateByExample(@Param("record") PToPKey record, @Param("example") PToPExample example);
}
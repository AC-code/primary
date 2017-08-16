package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.PrefectExample;
import com.primary.bean.PrefectKey;

public interface PrefectKeyService {
	public int countByExample(PrefectExample example);

	public int deleteByExample(PrefectExample example);

	public int deleteByPrimaryKey(PrefectKey key);

	public int insert(PrefectKey record);

	public int insertSelective(PrefectKey record);

	public List<PrefectKey> selectByExample(PrefectExample example);

	public int updateByExampleSelective(@Param("record") PrefectKey record, @Param("example") PrefectExample example);

	public int updateByExample(@Param("record") PrefectKey record, @Param("example") PrefectExample example);
}

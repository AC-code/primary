package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.primary.bean.Stuff;
import com.primary.bean.StuffExample;

public interface StuffService {
	public int countByExample(StuffExample example);

	public int deleteByExample(StuffExample example);

	public int deleteByPrimaryKey(Integer stuffid);

	public int insert(Stuff record);

	public int insertSelective(Stuff record);

	public List<Stuff> selectByExample(StuffExample example);

	public Stuff selectByPrimaryKey(Integer stuffid);

	public int updateByExampleSelective(@Param("record") Stuff record, @Param("example") StuffExample example);

	public int updateByExample(@Param("record") Stuff record, @Param("example") StuffExample example);

	public int updateByPrimaryKeySelective(Stuff record);

	public int updateByPrimaryKey(Stuff record);
}

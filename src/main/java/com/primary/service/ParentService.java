package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.Parent;
import com.primary.bean.ParentExample;

public interface ParentService {
	public int countByExample(ParentExample example);

	public int deleteByExample(ParentExample example);

	public int deleteByPrimaryKey(Integer parentid);

	public int insert(Parent record);

	public int insertSelective(Parent record);

	public List<Parent> selectByExample(ParentExample example);

	public Parent selectByPrimaryKey(Integer parentid);

	public int updateByExampleSelective(@Param("record") Parent record, @Param("example") ParentExample example);

	public int updateByExample(@Param("record") Parent record, @Param("example") ParentExample example);

	public int updateByPrimaryKeySelective(Parent record);

	public int updateByPrimaryKey(Parent record);
}

package com.primary.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primary.bean.Session;
import com.primary.bean.SessionExample;

public interface SessionService {
	public int countByExample(SessionExample example);

	public int deleteByExample(SessionExample example);

	public int deleteByPrimaryKey(Integer sessnid);

	public int insert(Session record);

	public int insertSelective(Session record);

	public List<Session> selectByExample(SessionExample example);

	public Session selectByPrimaryKey(Integer sessnid);

	public int updateByExampleSelective(@Param("record") Session record, @Param("example") SessionExample example);

	public int updateByExample(@Param("record") Session record, @Param("example") SessionExample example);

	public int updateByPrimaryKeySelective(Session record);

	public int updateByPrimaryKey(Session record);
}

package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.Session;
import com.primary.bean.SessionExample;
import com.primary.dao.SessionMapper;
import com.primary.service.SessionService;

@Service
public class SessionServiceObj implements SessionService {
	@Resource
	private SessionMapper sessionMapper;
	
	@Override
	public int countByExample(SessionExample example) {
		return sessionMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SessionExample example) {
		return sessionMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer sessnid) {
		return sessionMapper.deleteByPrimaryKey(sessnid);
	}

	@Override
	public int insert(Session record) {
		return sessionMapper.insert(record);
	}

	@Override
	public int insertSelective(Session record) {
		return sessionMapper.insertSelective(record);
	}

	@Override
	public List<Session> selectByExample(SessionExample example) {
		return sessionMapper.selectByExample(example);
	}

	@Override
	public Session selectByPrimaryKey(Integer sessnid) {
		return sessionMapper.selectByPrimaryKey(sessnid);
	}

	@Override
	public int updateByExampleSelective(Session record, SessionExample example) {
		return sessionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Session record, SessionExample example) {
		return sessionMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Session record) {
		return sessionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Session record) {
		return sessionMapper.updateByPrimaryKey(record);
	}

}

package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.Parent;
import com.primary.bean.ParentExample;
import com.primary.dao.ParentMapper;
import com.primary.service.ParentService;

@Service
public class ParentServiceObject implements ParentService {
	@Resource
	ParentMapper parentMapper;
	
	@Override
	public int countByExample(ParentExample example) {
		return parentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ParentExample example) {
		return parentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer parentid) {
		return parentMapper.deleteByPrimaryKey(parentid);
	}

	@Override
	public int insert(Parent record) {
		return parentMapper.insert(record);
	}

	@Override
	public int insertSelective(Parent record) {
		return parentMapper.insertSelective(record);
	}

	@Override
	public List<Parent> selectByExample(ParentExample example) {
		return parentMapper.selectByExample(example);
	}

	@Override
	public Parent selectByPrimaryKey(Integer parentid) {
		return parentMapper.selectByPrimaryKey(parentid);
	}

	@Override
	public int updateByExampleSelective(Parent record, ParentExample example) {
		return parentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Parent record, ParentExample example) {
		return parentMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Parent record) {
		return parentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Parent record) {
		return parentMapper.updateByPrimaryKey(record);
	}

}

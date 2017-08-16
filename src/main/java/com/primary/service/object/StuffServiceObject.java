package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.Stuff;
import com.primary.bean.StuffExample;
import com.primary.dao.StuffMapper;
import com.primary.service.StuffService;

@Service
public class StuffServiceObject implements StuffService {
	@Resource
	StuffMapper stuffMapper;

	public int countByExample(StuffExample example) {
		return stuffMapper.countByExample(example);
	}

	public int deleteByExample(StuffExample example) {
		return stuffMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer stuffid) {
		return stuffMapper.deleteByPrimaryKey(stuffid);
	}

	public int insert(Stuff record) {
		return stuffMapper.insert(record);
	}

	public int insertSelective(Stuff record) {
		return stuffMapper.insertSelective(record);
	}

	public List<Stuff> selectByExample(StuffExample example) {
		return stuffMapper.selectByExample(example);
	}

	public Stuff selectByPrimaryKey(Integer stuffid) {
		return stuffMapper.selectByPrimaryKey(stuffid);
	}

	public int updateByExampleSelective(Stuff record, StuffExample example) {
		return stuffMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Stuff record, StuffExample example) {
		return stuffMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(Stuff record) {
		return stuffMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Stuff record) {
		return stuffMapper.updateByPrimaryKey(record);
	}
	
}

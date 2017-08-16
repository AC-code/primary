package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.PrefectExample;
import com.primary.bean.PrefectKey;
import com.primary.dao.PrefectMapper;
import com.primary.service.PrefectKeyService;

@Service
public class PrefectKeyServiceObj implements PrefectKeyService {
	@Resource
	private PrefectMapper prefectMapper;
	
	@Override
	public int countByExample(PrefectExample example) {
		return prefectMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(PrefectExample example) {
		return prefectMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(PrefectKey key) {
		return prefectMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(PrefectKey record) {
		return prefectMapper.insert(record);
	}

	@Override
	public int insertSelective(PrefectKey record) {
		return prefectMapper.insertSelective(record);
	}

	@Override
	public List<PrefectKey> selectByExample(PrefectExample example) {
		return prefectMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(PrefectKey record, PrefectExample example) {
		return prefectMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(PrefectKey record, PrefectExample example) {
		return prefectMapper.updateByExample(record, example);
	}

}

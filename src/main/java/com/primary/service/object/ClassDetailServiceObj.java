package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.ClassDetail;
import com.primary.bean.ClassDetailExample;
import com.primary.dao.ClassDetailMapper;
import com.primary.service.ClassDetailService;

@Service
public class ClassDetailServiceObj implements ClassDetailService {
	@Resource
	private ClassDetailMapper classDetailMapper;
	
	@Override
	public int countByExample(ClassDetailExample example) {
		return classDetailMapper.countByExample(example);
	}

	@Override
	public List<ClassDetail> selectByExample(ClassDetailExample example) {
		return classDetailMapper.selectByExample(example);
	}

}

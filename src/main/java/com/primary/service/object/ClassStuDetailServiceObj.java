package com.primary.service.object;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.primary.bean.ClassStuDetail;
import com.primary.bean.ClassStuDetailExample;
import com.primary.bean.ClassStuDetailExample.Criteria;
import com.primary.dao.ClassStuDetailMapper;
import com.primary.service.ClassStuDetailService;
import com.primary.util.Log;

@Service
public class ClassStuDetailServiceObj implements ClassStuDetailService {
	@Resource
	private ClassStuDetailMapper classStuDetailMapper;

	@Override
	public int countByExample(ClassStuDetailExample example) {
		return classStuDetailMapper.countByExample(example);
	}

	@Override
	public List<ClassStuDetail> selectByExample(ClassStuDetailExample example) {
		return classStuDetailMapper.selectByExample(example);
	}

	@Override
	public Map<String, Object> selectByParams(Integer page, Integer rows, Integer classid, Integer stuid,
			String stuname, Integer number) {
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		ClassStuDetailExample example = new ClassStuDetailExample();
		
		Criteria criteria = example.createCriteria();
		
		if (classid != null) {
			criteria.andClassidEqualTo(classid);
		}
		
		if (stuid != null) {
			criteria.andStuidEqualTo(stuid);
		}
		
		if (stuname != null && stuname.length() > 0) {
			criteria.andStunameLike("%" + stuname + "%");
		}
		
		if (number != null) {
			criteria.andNumberEqualTo(number);
		}
		
		List<ClassStuDetail> datas = selectByExample(example);
		
		Integer total = countByExample(example);
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("total", total);
		result.put("data", datas);
		
		return result;
	}
}

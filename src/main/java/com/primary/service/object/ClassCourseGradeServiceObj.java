package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.primary.bean.ClassCourseGrade;
import com.primary.bean.ClassCourseGradeExample;
import com.primary.bean.ClassCourseGradeExample.Criteria;
import com.primary.dao.ClassCourseGradeMapper;
import com.primary.service.ClassCourseGradeService;
import com.primary.util.SQLUtil;

@Service
public class ClassCourseGradeServiceObj implements ClassCourseGradeService {
	@Resource
	private ClassCourseGradeMapper classCourseGradeMapper;
	
	@Override
	public int countByExample(ClassCourseGradeExample example) {
		return classCourseGradeMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ClassCourseGradeExample example) {
		return classCourseGradeMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return classCourseGradeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ClassCourseGrade record) {
		return classCourseGradeMapper.insert(record);
	}

	@Override
	public int insertSelective(ClassCourseGrade record) {
		return classCourseGradeMapper.insertSelective(record);
	}

	@Override
	public List<ClassCourseGrade> selectByExample(ClassCourseGradeExample example) {
		return classCourseGradeMapper.selectByExample(example);
	}

	@Override
	public ClassCourseGrade selectByPrimaryKey(Integer id) {
		return classCourseGradeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(ClassCourseGrade record, ClassCourseGradeExample example) {
		return classCourseGradeMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ClassCourseGrade record, ClassCourseGradeExample example) {
		return classCourseGradeMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ClassCourseGrade record) {
		return classCourseGradeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ClassCourseGrade record) {
		return classCourseGradeMapper.updateByPrimaryKey(record);
	}

	@Override
	public ClassCourseGradeExample createDefalutExample(ClassCourseGrade classCourseGrade) {
		ClassCourseGradeExample example = new ClassCourseGradeExample();
		Criteria criteria = example.createCriteria();
		
		if (classCourseGrade == null) {
			return example;
		}
		
		if (classCourseGrade.getId() != null) {
			criteria.andIdEqualTo(classCourseGrade.getId());
		}
		
		if (classCourseGrade.getClassid() != null) {
			criteria.andClassidEqualTo(classCourseGrade.getClassid());
		}
		
		if (classCourseGrade.getgCId() != null) {
			criteria.andGCIdEqualTo(classCourseGrade.getgCId());
		}
		
		if (!StringUtils.isEmpty(classCourseGrade.getName())) {
			criteria.andNameLike(SQLUtil.toLike(classCourseGrade.getName()));
		}
		
		return example;
	}

}

package com.primary.service.object;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.primary.bean.ClassCourseGrade;
import com.primary.bean.ClassStu;
import com.primary.bean.ClassStuExample;
import com.primary.bean.Score;
import com.primary.bean.ScoreExample;
import com.primary.bean.ScoreKey;
import com.primary.dao.ScoreMapper;
import com.primary.service.ClassCourseGradeService;
import com.primary.service.ClassStuService;
import com.primary.service.ScoreService;

@Service
public class ScoreServiceObj implements ScoreService {
	@Resource
	private ScoreMapper scoreMapper;
	@Resource
	private ClassCourseGradeService classCourseGradeService;
	@Resource 
	private ClassStuService classStuService;
	
	@Override
	public int countByExample(ScoreExample example) {
		return scoreMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ScoreExample example) {
		return scoreMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(ScoreKey key) {
		return scoreMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Score record) {
		return scoreMapper.insert(record);
	}

	@Override
	public int insertSelective(Score record) {
		return scoreMapper.insertSelective(record);
	}

	@Override
	public List<Score> selectByExample(ScoreExample example) {
		return scoreMapper.selectByExample(example);
	}

	@Override
	public Score selectByPrimaryKey(ScoreKey key) {
		return scoreMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByExampleSelective(Score record, ScoreExample example) {
		return scoreMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Score record, ScoreExample example) {
		return scoreMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Score record) {
		return scoreMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Score record) {
		return scoreMapper.updateByPrimaryKey(record);
	}

	@Override
	public void createScores(Integer id) {
		//根据成绩id查询班级id
		ClassCourseGrade classCourseGrade = classCourseGradeService.selectByPrimaryKey(id);
		
		//根据班级id获取学生
		ClassStuExample example = new ClassStuExample();
		example.createCriteria().andClassidEqualTo(classCourseGrade.getClassid());
		List<ClassStu> list = classStuService.selectByExample(example);
		
		//为每个学生创建成绩
		for (ClassStu stu : list) {
			Score score = new Score();
			score.setClassid(stu.getClassid());
			score.setId(id);
			score.setMark(new Float(0));
			score.setNumber(stu.getNumber());
			insert(score);
		}
	}

}

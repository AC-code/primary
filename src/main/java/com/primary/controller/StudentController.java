package com.primary.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.primary.annotation.RequestPermission;
import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.bean.Student;
import com.primary.bean.StudentExample;
import com.primary.bean.StudentExample.Criteria;
import com.primary.service.StudentService;
import com.primary.util.CheckUtil;
import com.primary.util.FileUtil;
import com.primary.util.JSONUtil;
import com.primary.util.Log;
import com.primary.util.StudentUtil;

@Controller
@RequestPermission(role=RequestPermissionParser.role_admin)
public class StudentController {
	@Resource
	private StudentService studentService;
	
	@RequestMapping(value="/student/stuMain")
	@RequestPermission(role=RequestPermissionParser.role_student)
	public String stuMain() {
		return "/student/stuMain";
	}
	
	@ResponseBody
	@RequestMapping(value="/student/findStudent")
	@RequestPermission(role=RequestPermissionParser.role_stuff)
	public String findStudent(Integer page, Integer rows, Integer fstuid, Integer tstuid, String stuname) {
		StudentExample studentExample = new StudentExample();
		
		//构造查询条件
		Criteria criteria = studentExample.createCriteria();
		if (fstuid != null) {
			criteria.andStuidGreaterThanOrEqualTo(fstuid);
		}
		if (tstuid != null) {
			criteria.andStuidLessThanOrEqualTo(tstuid);
		}
		if (stuname != null && stuname.length() > 0) {
			criteria.andStunameLike("%" + stuname + "%");
		}
		
		if (page != null && rows != null) {
			PageHelper.startPage(page, rows);
		}
		
		List<Student> students = studentService.selectByExample(studentExample);
		
		JSONArray array = new JSONArray();
		
		for (Student student : students) {
			array.put(new JSONObject(student));
		}
		
		Log.info(array);
		
		JSONObject result = new JSONObject();
		
		result.put("total", studentService.countByExample(studentExample));
		result.put("rows", array);
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/student/studentAdd")
	public String studentAdd(Integer stuid, String stuname, String password) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(stuid, stuname, password) || stuname.length() < 1 || password.length() < 1) {
			result.put("message", "添加失败,存在非法数据");
			
			return result.toString();
		}
		
		studentService.createStudent(new Student(stuid, stuname, password));
		
		result.put("message", "添加成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/student/studentDelete")
	public String studentDelete(Integer stuid) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(stuid)) {
			result.put("message", "删除失败,存在非法数据");
			
			return result.toString();
		}
		
		studentService.removeStudentByPrimaryKey(stuid);
		
		result.put("message", "删除成功");
		
		return result.toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/student/studentUpdate")
	@RequestPermission(role=RequestPermissionParser.role_student, isStrict=true)
	public String studentUpdate(Integer stuid, String stuname, String password) {
		JSONObject result = new JSONObject();
		
		if (CheckUtil.nullCheck(stuid, stuname, password) || stuname.length() < 1 || password.length() < 1) {
			result.put("message", "修改失败,存在非法数据");
			
			return result.toString();
		}
		
		studentService.updateByPrimaryKey(new Student(stuid, stuname, password));
		
		result.put("message", "修改成功");
		
		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/student/lotStu")
	public String lotStu(@RequestParam("file") CommonsMultipartFile file, Integer start_id) throws IllegalStateException, IOException {
		if (file == null || !FileUtil.isXlsFile(file.getOriginalFilename()) || start_id == null) {
			return JSONUtil.getJsonObj("message", "请正确输入");
		}
		
		List<Student> students = StudentUtil.XLSToStudents(start_id, file.getInputStream());
		
		if (students == null || studentService.countByExample(studentService.betweenPrimaryExample(start_id, start_id + students.size())) > 0) {
			return JSONUtil.getJsonObj("message", "名单数据出错,可能学生学号区间已被占用");
		}
		
		studentService.insert(students);
		
		return JSONUtil.getJsonObj("message", "添加成功");
	}
}

package com.primary.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primary.annotation.RequestPermission;
import com.primary.bean.Parent;
import com.primary.bean.Student;
import com.primary.bean.StudentParent;
import com.primary.bean.StudentParentExample;
import com.primary.bean.Stuff;
import com.primary.service.ParentService;
import com.primary.service.StuParService;
import com.primary.service.StudentService;
import com.primary.service.StuffService;
import com.primary.util.CheckUtil;

@Controller
@RequestPermission
public class LoginController {
	@Resource
	private StuffService stuffService;
	@Resource
	private StudentService studentService;
	@Resource
	private StuParService stuParService;
	
	@RequestMapping(value="/login/stuffLogin")
	public String stuffLogin(Integer stuffid, String password, HttpSession session) {
		if (CheckUtil.nullCheck(stuffid, password) || password.length() < 1) {
			return "redirect:/stuffLogin.do";
		}
		
		Stuff stuff = stuffService.selectByPrimaryKey(stuffid);
		
		if (stuff != null && stuff.getPassword().equals(password)) {
			session.setAttribute("stuff", stuff);
			
			return "redirect:/stuff/stuffMain.do";
		}
		
		return "redirect:/stuffLogin.do";
	}
	
	@RequestMapping(value="/login/userLogin")
	public String userLogin(Integer id, String password, Integer role, HttpSession session) {
		if (role == null) {
			return "redirect:/login.do";
		}
		
		switch (role) {
		case 1:
			return stuLogin(id, password, session);
		case 2:
			return parentLogin(id, password, session);
		default:
			break;
		}
		
		return "redirect:/login.do"; 
	}
	
	public String stuLogin(Integer stuid, String password, HttpSession session) {
		if (CheckUtil.nullCheck(stuid, password) || password.length() < 1) {
			return "redirect:/login.do";
		}
		
		Student student = studentService.selectByPrimaryKey(stuid);
		
		if (student != null && student.getPassword() != null && student.getPassword().equals(password)) {
			session.setAttribute("student", student);
			
			return "redirect:/student/stuMain.do";
		}
		
		return "redirect:/login.do";
	}
	
	public String parentLogin(Integer parentid, String password, HttpSession session) {
		if (CheckUtil.nullCheck(parentid, password) || password.length() < 1) {
			return "redirect:/parentLogin.do";
		}
		
		StudentParentExample example = new StudentParentExample();
		
		example.createCriteria().andParentidEqualTo(parentid);
		
		List<StudentParent> result = stuParService.selectByExample(example);
		
		StudentParent parent = new StudentParent();
		
		if (result != null && result.size() == 1) {
			parent = result.get(0);
		}
		
		if (parent != null && parent.getPassword() != null && parent.getPassword().equals(password)) {
			session.setAttribute("parent", parent);
			
			return "redirect:/parent/parentMain.do";
		}
		
		return "redirect:/login.do";
	}
	
	@RequestMapping(value="/login/logOut")
	public String logOut(HttpSession session) {
		if (session.getAttribute("stuff") != null) {
			session.invalidate();
			
			return "redirect:/stuffLogin.do";
		}
		
		session.invalidate();
		
		return "redirect:/login.do";
	}
	
	@RequestMapping(value="login")
	public String login() {
		return "/login";
	}
	
	@RequestMapping(value="stuffLogin")
	public String stuffLogin() {
		return "/stuffLogin";
	}
}

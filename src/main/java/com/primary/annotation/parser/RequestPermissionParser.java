package com.primary.annotation.parser;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;

import com.primary.annotation.RequestPermission;
import com.primary.bean.Student;
import com.primary.bean.StudentParent;
import com.primary.bean.Stuff;
import com.primary.util.CheckUtil;
import com.primary.util.Log;

public class RequestPermissionParser {
	public static final String role_default = "default";
	public static final String role_admin = "admin";
	public static final String role_stuff = "stuff";
	public static final String role_student = "student";
	public static final String role_parent = "parent";
	
	public boolean parse(Object handler, HttpServletRequest request) {
		if (CheckUtil.nullCheck(handler, request)) {
			return false;
		}
		
		if (!(handler instanceof HandlerMethod)) {
			return false;
		}
		
		HandlerMethod hMethod = (HandlerMethod) handler;
		
		//获取权限
		//查看方法是否有标注权限
		Log.info("方法权限拦截开始");
		Method method = hMethod.getMethod();
		if (method != null && method.isAnnotationPresent(RequestPermission.class)) {
			if(doChechk(method.getAnnotation(RequestPermission.class), request)) {
				return true;
			}
		}
		
		Log.info("方法权限未通过");
		
		//查看类是否有标注权限
		Log.info("类权限拦截开始");
		Class<?> clazz = hMethod.getBeanType();
		if (clazz != null && clazz.isAnnotationPresent(RequestPermission.class)) {
			if(doChechk(clazz.getAnnotation(RequestPermission.class), request)) {
				return true;
			}
		}
		
		Log.info("类权限未通过");
		
		//都无权限,返回false
		return false;
	}

	public boolean doChechk(RequestPermission annotation, HttpServletRequest request) {
		String role = annotation.role();
		boolean strict = annotation.isStrict();
		HttpSession session = request.getSession();
		
		Log.info("允许通过类型" + role + "  约束" + strict);
		
		switch (role) {
		case role_default:
			return true;
		case role_admin:
			return adminLogin(session);
		case role_stuff:
			return stuffLogin(session) && stuffStrict(session, request, strict);
		case role_student:
			return studentLogin(session) && studentStrict(session, request, strict);
		case role_parent:
			return parentLogin(session) && parentStrict(session, request, strict);
		default:
			break;
		}
		
		return false;
	}
	
	private boolean parentStrict(HttpSession session, HttpServletRequest request, boolean strict) {
		if (!strict) {
			return true;
		}
		
		//获取家长
		StudentParent parent = (StudentParent) session.getAttribute("parent");
		
		//获取传过来的学生id以及家长id
		String stuid = request.getParameter("stuid");
		String parentid = request.getParameter("parentid");
		
		if (stuid != null && !parent.getParentid().toString().equals(stuid)) {
			Log.info("学生账号非法");
			return false;
		}
		
		if (parentid != null && !parent.getParentid().toString().equals(parentid)) {
			Log.info("学生账号非法");
			return false;
		}
		
		return true;
	}

	private boolean studentStrict(HttpSession session, HttpServletRequest request, boolean strict) {
		if (!strict) {
			return true;
		}
		
		String stuid = request.getParameter("stuid");
		
		if (stuid == null || !stuid.equals(((Student)session.getAttribute("student")).getStuid().toString())) {
			Log.info("学号非法");
			return false;
		}
		
		return true;
	}

	public boolean adminLogin(HttpSession session) {
		Stuff stuff = (Stuff) session.getAttribute("stuff");
		
		if (stuff == null) {
			return false;
		}
		
		return stuff.getAuthority() % 2 == 1;
	}
	
	public boolean stuffLogin(HttpSession session) {
		return session.getAttribute("stuff") != null;
	}
	
	public boolean stuffStrict(HttpSession session, HttpServletRequest request, boolean strict) {
		if (!strict) {
			return true;
		}
		
		String stuffid = request.getParameter("stuffid");
		
		if (stuffid == null || !stuffid.equals(((Stuff)session.getAttribute("stuff")).getStuffid().toString())) {
			Log.info("职工号非法");
			return false;
		}
		
		return true;
	}
	
	public boolean studentLogin(HttpSession session) {
		return session.getAttribute("student") != null;
	}
	
	public boolean parentLogin(HttpSession session) {
		return session.getAttribute("parent") != null;
	}
}

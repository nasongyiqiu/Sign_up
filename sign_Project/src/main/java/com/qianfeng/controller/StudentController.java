package com.qianfeng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.Student;
import com.qianfeng.service.IStudentService;

@Controller
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping("/studentregister.do")
	@ResponseBody
	public Map<String, Object> studentregister(Student student,String repassword){
		Map<String, Object> map = new HashMap<>();
		
		try {
			student.setFlag(1);
			int ret = studentService.register(student,repassword);
			if (ret == 0) {
				map.put("msg", "该用户名已被抢先注册，请更换用户名");
			}else if (ret == 2) {
				map.put("msg", "两次输入的密码不一致，注册失败");
			}else {
				map.put("msg", "注册成功");
			}
			map.put("code", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 1);
		}
		return map;
	}
	
	@RequestMapping("/studentlogin.do")
	@ResponseBody
	public Map<String, Object> studentlogin(HttpServletRequest request,String username,String password){
		Map<String, Object> map = new HashMap<>();
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			request.getSession().setAttribute("username", username);
			map.put("code", 0);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 1);
			map.put("msg", "用户名或密码错误，登录失败");
		}
		return map;
		
	}
	
	@RequestMapping("/findMySelf.do")
	@ResponseBody
	public Map<String, Object> findMySelf(HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		
		try {
			Student student = studentService.findMySelf(request);
			map.put("data", student);
			map.put("code", 0);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 1);
		}
		return map;
		
	}
	
	@RequestMapping("/updateStudent.do")
	@ResponseBody
	public Map<String, Object> updateStudent(Student student,HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		Student student1 = studentService.findMySelf(request);
		try {
			student.setId(student1.getId());
			studentService.updateStudent(student);
			map.put("msg", "编辑成功");
			map.put("code", 0);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 1);
		}
		return map;
		
	}


}

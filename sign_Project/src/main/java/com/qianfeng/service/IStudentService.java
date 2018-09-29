package com.qianfeng.service;

import javax.servlet.http.HttpServletRequest;

import com.qianfeng.entity.Student;

public interface IStudentService {
	public int register(Student student,String repassword);
	
	public Student findMySelf(HttpServletRequest request);
	
	public void updateStudent(Student student);

}

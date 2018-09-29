package com.qianfeng.dao;


import com.qianfeng.entity.Student;

public interface IStudentDao {
	public Student findStudentByName(String username);
	
	public void addStudent(Student student);
	
	public void updateStudent(Student student);
}
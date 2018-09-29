package com.qianfeng.service.Impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.IStudentDao;
import com.qianfeng.entity.Student;
import com.qianfeng.service.IStudentService;
@Service
public class StudentServiceImpl implements IStudentService{
	@Autowired
	private IStudentDao studentDao;

	@Override
	public int register(Student student,String repassword) {
		// TODO Auto-generated method stub
		try {
			Student student2 = studentDao.findStudentByName(student.getUsername());
			if (student2 != null) {
				//已经有同名的用户，无法注册
				return 0;
			}else {
				if (!student.getPassword().equals(repassword)) {
					return 2;
				}else {
					try {
						studentDao.addStudent(student);
						return 1;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Student findMySelf(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Student student = studentDao.findStudentByName((String)request.getSession().getAttribute("username"));
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			studentDao.updateStudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

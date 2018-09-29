package com.qianfeng.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.ISigninDao;
import com.qianfeng.dao.IStudentDao;
import com.qianfeng.entity.Signin;
import com.qianfeng.entity.Student;
import com.qianfeng.service.ISigninService;
import com.qianfeng.vo.PageBean;
@Service
public class SigninServiceImpl implements ISigninService{
	@Autowired
	private ISigninDao signDao;
	@Autowired
	private IStudentDao studentDao;

	@Override
	public PageBean<Signin> findAllSigninByPage(Integer page, Integer limit, HttpServletRequest request) {
		// TODO Auto-generated method stub
		PageBean<Signin> pageInfo = new PageBean<>();
		
		String username = (String) request.getSession().getAttribute("username");
		Student student = null;
		try {
			student = studentDao.findStudentByName(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageInfo.setPageSize(limit);
		
		Map<String,Object> map = new HashMap<>();
		map.put("flag", 1);
		map.put("uid", student.getId());
		// 获取表中的记录总数
		int count = signDao.count(map);
		// 设置总记录数
		pageInfo.setCount(count);
		int index = (page - 1) * pageInfo.getPageSize();
		
		map.put("index", index);
		map.put("size", pageInfo.getPageSize());
		List<Signin> list = signDao.findAllSignin(map);
		
		pageInfo.setPageInfos(list);
		
		return pageInfo;
		
	}

	@Override
	public int addSignin(Integer flag, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Signin signin = new Signin();
		Date date = new Date();
		Map<String, Object> map = new HashMap<>();
		
		Student student = studentDao.findStudentByName((String)request.getSession().getAttribute("username"));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String time = simpleDateFormat.format(date);
		String eight = time.substring(0,9) + " 08:00:00";
		String nine = time.substring(0,9) + " 09:00:00";
		String twentyone = time.substring(0,9) + " 21:00:00";
		String twentytwo = time.substring(0,9) + " 22:00:00";
		Date eight1 = null;
		Date nine1 = null;
		Date twentyone1 = null;
		Date twentytwo1 = null;
		try {
			eight1 = simpleDateFormat.parse(eight);
			nine1 = simpleDateFormat.parse(nine);
			twentyone1 = simpleDateFormat.parse(twentyone);
			twentytwo1 = simpleDateFormat.parse(twentytwo);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signin.setFlag(1);
		signin.setUid(student.getId());
		signin.setSigntime(date);
		
		map.put("uid", student.getId());
		map.put("signtime", time.substring(0,9)+"%");
		
		int ret = 0;
		if (flag==1) {
			signin.setSigninfo("上班打卡");
			
			map.put("signinfo", "上班打卡");
			
			Signin signin2 = signDao.findSignin(map);
			if (signin2 == null) {
				
				if (date.getTime()>nine1.getTime()) {
					signin.setState("迟到");
					signDao.addSignin(signin);
				}else {
					signin.setState("正常");
					signDao.addSignin(signin);
				}
				ret = 1;
			}
		}else if (flag==2) {
			signin.setSigninfo("下班打卡");
			map.put("signinfo", "下班打卡");
			Signin signin2 = signDao.findSignin(map);
			if (signin2 == null) {
				if (date.getTime()>twentyone1.getTime()) {
					signin.setState("早退");
					signDao.addSignin(signin);
				}else {
					signin.setState("正常");
					signDao.addSignin(signin);
				}
				ret = 1;
			}
		}
		return ret;
	}

	@Override
	public void deleteSign(Integer id) {
		// TODO Auto-generated method stub
//		 Student student = studentDao.findStudentByName((String)request.getSession().getAttribute("username"));
		 try {
			signDao.deleteSignin(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		
	}
	
	

}

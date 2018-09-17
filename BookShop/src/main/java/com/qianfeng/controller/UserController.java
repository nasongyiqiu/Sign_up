package com.qianfeng.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.UserInfo;
import com.qianfeng.service.IUserInfoService;
import com.qianfeng.util.JsonUtil;
import com.qianfeng.vo.JsonBean;

@Controller
public class UserController {
	@Autowired
	private IUserInfoService userInfoService;
	
	@RequestMapping("/login")
	@ResponseBody
	public JsonBean login(HttpServletRequest request, String userName, String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		Subject subject = SecurityUtils.getSubject();
		HttpSession session = request.getSession();
		JsonBean bean = new JsonBean();
		try {
			subject.login(token);
			session.setAttribute("username", userName);
			bean.setCode(1);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public JsonBean register(UserInfo userInfo) {
		try {
			userInfoService.addUserInfo(userInfo);
			return JsonUtil.getJsonBean(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtil.getJsonBean(0, e.getMessage());
		}
	}

	@RequestMapping("/unLogin")
	@ResponseBody
	public JsonBean unLogin(HttpServletRequest request) {
		request.getSession().invalidate();
		return JsonUtil.getJsonBean(1, null);
	}
	

}

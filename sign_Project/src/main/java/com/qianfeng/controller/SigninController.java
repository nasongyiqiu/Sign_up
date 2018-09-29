package com.qianfeng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.Signin;
import com.qianfeng.service.ISigninService;
import com.qianfeng.vo.PageBean;

@Controller
public class SigninController {
	@Autowired
	private ISigninService signinService;
	
	@RequestMapping("/signin.do")
	@ResponseBody
	public Map<String, Object> signin(Integer page,Integer limit,HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		
		try {
			PageBean<Signin> pageBean = signinService.findAllSigninByPage(page, limit, request);
			map.put("code", 0);
			map.put("count", pageBean.getCount());
			map.put("data", pageBean.getPageInfos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 1);
		}
		
		return map;
	}
	
	@RequestMapping("/onwork.do")
	@ResponseBody
	public Map<String, Object> onwork(Integer flag,HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		try {
			int ret = signinService.addSignin(flag, request);
			if (ret == 0) {
				map.put("msg", "已打过卡，不需要再打卡");
			}else {
				map.put("msg", "打卡成功");
			}
			map.put("code", 0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 1);
			map.put("msg", "打卡失败");
		}
		
		return map;
	}
	
	@RequestMapping("/deleteSign")
	@ResponseBody
	public Map<String, Object> deleteSign(Integer id){
		Map<String, Object> map = new HashMap<>();
		try {
			signinService.deleteSign(id);
			map.put("code", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 1);
		}
		return map;
	}

}

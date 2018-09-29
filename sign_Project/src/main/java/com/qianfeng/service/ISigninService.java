package com.qianfeng.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qianfeng.entity.Signin;
import com.qianfeng.vo.PageBean;

public interface ISigninService {
	public PageBean<Signin> findAllSigninByPage(Integer page,Integer limit,HttpServletRequest request);

	public int addSignin(Integer flag,HttpServletRequest request);
	
	public void deleteSign(Integer id);
	
}

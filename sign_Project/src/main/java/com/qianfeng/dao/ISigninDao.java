package com.qianfeng.dao;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.Signin;

public interface ISigninDao {
	
	public List<Signin> findAllSignin(Map<String, Object> map);
	
	public int count(Map<String, Object> map);
	
	public void addSignin(Signin signin);
	
	public void deleteSignin(int id);
	
	public Signin findSignin(Map<String, Object> map);

}

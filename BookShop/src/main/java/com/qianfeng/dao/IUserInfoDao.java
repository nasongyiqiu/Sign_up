package com.qianfeng.dao;

import com.qianfeng.entity.UserInfo;

public interface IUserInfoDao {
	public UserInfo findByName(String userName);
	
	public void addUserInfo(UserInfo userInfo);

}

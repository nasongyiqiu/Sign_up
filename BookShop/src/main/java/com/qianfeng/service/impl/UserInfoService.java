package com.qianfeng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.IUserInfoDao;
import com.qianfeng.entity.UserInfo;
import com.qianfeng.service.IUserInfoService;
@Service
public class UserInfoService implements IUserInfoService{

	@Autowired
	private IUserInfoDao userInfoDao;

	@Override
	public void addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		if (userInfo == null) {
			throw new RuntimeException("参数传入不正确");
		}
		UserInfo user = userInfoDao.findByName(userInfo.getUserName());
		if (user != null) {
			throw new RuntimeException("参数传入不正确");
		}
		if (!userInfo.getPassword().equals(userInfo.getRePassWord())) {
			throw new RuntimeException("密码和确认密码不一致");
		}
		userInfoDao.addUserInfo(userInfo);
	}

}

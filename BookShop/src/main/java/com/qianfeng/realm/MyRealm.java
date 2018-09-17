package com.qianfeng.realm;

import java.io.IOException;
import java.io.Reader;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.qianfeng.dao.IUserInfoDao;
import com.qianfeng.entity.UserInfo;


public class MyRealm extends AuthorizingRealm{
	@Autowired
	private IUserInfoDao userInfo;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		
		return null;
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String name = (String) token.getPrincipal();
		UserInfo user = userInfo.findByName(name);
		if (user == null) {
			throw new UnknownAccountException();
		}
		String password = user.getPassword();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name, password,this.getName());
		
		return info;
	}
	
	

}

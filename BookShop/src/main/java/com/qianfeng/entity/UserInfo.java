package com.qianfeng.entity;

import java.io.Serializable;

public class UserInfo implements Serializable{
	private String userName;
	private String password;
	private String rePassWord;
	private String email;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the rePassWord
	 */
	public String getRePassWord() {
		return rePassWord;
	}
	/**
	 * @param rePassWord the rePassWord to set
	 */
	public void setRePassWord(String rePassWord) {
		this.rePassWord = rePassWord;
	}
	
	
}

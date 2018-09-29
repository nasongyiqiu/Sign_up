package com.qianfeng.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Signin {
	private Integer id;
	private Integer uid;
	private String username;
	private Date signtime;
	private String signinfo;
	private String state;
	private Integer flag;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	/**
	 * @return the signtime
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getSigntime() {
		return signtime;
	}
	/**
	 * @param signtime the signtime to set
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public void setSigntime(Date signtime) {
		this.signtime = signtime;
	}
	/**
	 * @return the signinfo
	 */
	public String getSigninfo() {
		return signinfo;
	}
	/**
	 * @param signinfo the signinfo to set
	 */
	public void setSigninfo(String signinfo) {
		this.signinfo = signinfo;
	}
	/**
	 * @return the flag
	 */
	public Integer getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}

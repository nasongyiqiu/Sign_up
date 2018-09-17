package com.qianfeng.vo;

import java.util.Date;

public class OrdersAndStatus {
	private Integer iId;
	private String bookName;
	private String image;
	private String userName;
	private Double total_Price;
	private Date createDate;
	private Integer state;
	
	/**
	 * @return the iId
	 */
	public Integer getiId() {
		return iId;
	}
	/**
	 * @param iId the iId to set
	 */
	public void setiId(Integer iId) {
		this.iId = iId;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
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
	 * @return the total_Price
	 */
	public Double getTotal_Price() {
		return total_Price;
	}
	/**
	 * @param total_Price the total_Price to set
	 */
	public void setTotal_Price(Double total_Price) {
		this.total_Price = total_Price;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	

}

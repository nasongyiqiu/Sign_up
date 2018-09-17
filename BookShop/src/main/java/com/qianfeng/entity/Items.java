package com.qianfeng.entity;

import java.util.Date;

public class Items {
	private Integer iId;
	private Integer oId;
	private Integer bId;
	private Date createDate;
	private Integer num;
	private Double price;
	private int state;
	private Double total_Price;
	private Orders orders;
	private Book book;
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
	 * @return the oId
	 */
	public Integer getoId() {
		return oId;
	}
	/**
	 * @param oId the oId to set
	 */
	public void setoId(Integer oId) {
		this.oId = oId;
	}
	/**
	 * @return the bId
	 */
	public Integer getbId() {
		return bId;
	}
	/**
	 * @param bId the bId to set
	 */
	public void setbId(Integer bId) {
		this.bId = bId;
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
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
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
	 * @return the orders
	 */
	public Orders getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	

}

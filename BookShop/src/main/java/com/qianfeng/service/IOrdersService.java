package com.qianfeng.service;

import java.util.List;

import com.qianfeng.vo.OrdersAndStatus;

public interface IOrdersService {
//	public int addOrders(Orders orders);
	
	public void addItems(String userName,Integer bId);
	
	public List<OrdersAndStatus> findItem(String userName);
	
	public List<OrdersAndStatus> searchOrder(String userName,String bookName);
	
	public void deleteBybId(String userName,Integer bId);
}

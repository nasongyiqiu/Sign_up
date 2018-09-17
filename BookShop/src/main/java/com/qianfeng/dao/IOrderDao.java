package com.qianfeng.dao;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.Orders;

public interface IOrderDao {
	public int addOrders(Orders orders);
	
	public List<Orders> findByUserName(String userName);
	
	public void deleteBybId(Map<String, Object> map);

}

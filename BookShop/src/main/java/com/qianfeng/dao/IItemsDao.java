package com.qianfeng.dao;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.Items;
import com.qianfeng.vo.OrdersAndStatus;

public interface IItemsDao {
	
	public void addItems(Items items);
	
	public List<OrdersAndStatus> findOrderByTiJian(String userName);
	
	public List<OrdersAndStatus> searchOrder(Map<String, Object> map);

}

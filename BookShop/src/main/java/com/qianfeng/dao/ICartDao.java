package com.qianfeng.dao;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.Cart;
import com.qianfeng.vo.CartAndBooks;

public interface ICartDao {
	public List<CartAndBooks> findAllCart(String userName);
	
	public Cart findBybId(Cart cart);
	
	public void addBybId(Cart cart);
	
	public void updataCartNum(Cart cart);
	
	public List<CartAndBooks> searchCart(Map<String, Object> map);
	
	

}

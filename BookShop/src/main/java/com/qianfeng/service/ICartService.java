package com.qianfeng.service;

import java.util.List;

import com.qianfeng.entity.Cart;
import com.qianfeng.vo.CartAndBooks;

public interface ICartService {
	public List<CartAndBooks> findAllCart(String userName);
	
	public void addBybId(Cart cart);
	
	public Cart findBybId(Cart cart);
	
	public void updataCartNum(Cart cart);
	
	public List<CartAndBooks> searchCart(String userName,String bookName);

}

package com.qianfeng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.ICartDao;
import com.qianfeng.entity.Cart;
import com.qianfeng.service.ICartService;
import com.qianfeng.vo.CartAndBooks;
@Service
public class CartService implements ICartService{
	@Autowired
	private ICartDao cartDao;

	@Override
	public void addBybId(Cart cart) {
		// TODO Auto-generated method stub
		try {
			cartDao.addBybId(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Cart findBybId(Cart cart) {
		// TODO Auto-generated method stub
		Cart cartr = cartDao.findBybId(cart);
		return cartr;
	}

	@Override
	public void updataCartNum(Cart cart) {
		// TODO Auto-generated method stub
		try {
			cartDao.updataCartNum(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CartAndBooks> findAllCart(String userName) {
		// TODO Auto-generated method stub
		List<CartAndBooks> list = null;
		try {
			list = cartDao.findAllCart(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CartAndBooks> searchCart(String userName,String bookName) {
		// TODO Auto-generated method stub
		List<CartAndBooks> list = null;
		Map<String, Object> map = new HashMap<>();
		try {
			bookName = "%" + bookName + "%";
			map.put("userName", userName);
			map.put("bookName", bookName);
			list = cartDao.searchCart(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

}

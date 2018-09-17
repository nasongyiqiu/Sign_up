package com.qianfeng.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.IBookDao;
import com.qianfeng.dao.ICartDao;
import com.qianfeng.dao.IItemsDao;
import com.qianfeng.dao.IOrderDao;
import com.qianfeng.entity.Book;
import com.qianfeng.entity.Cart;
import com.qianfeng.entity.Items;
import com.qianfeng.entity.Orders;
import com.qianfeng.service.IOrdersService;
import com.qianfeng.vo.OrdersAndStatus;

@Service
public class OrdersService implements IOrdersService{
	
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IBookDao bookDao;
	@Autowired
	private ICartDao cartDao;
	@Autowired
	private IItemsDao itemsDao;
	
	public void addItems(String userName,Integer bId) {
		
		int oId = 0;
		Orders orders = new Orders();
		orders.setUserName(userName);
		try {
			orderDao.addOrders(orders);
			oId = orders.getoId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Book book = bookDao.findBybId(bId);
		Cart cartc = new Cart();
		cartc.setbId(bId);
		cartc.setUserName(userName);
		Cart cart = cartDao.findBybId(cartc);
		
		Items items = new Items();
		items.setbId(bId);
		items.setCreateDate(new Date());
		items.setNum(cart.getNum());
		items.setoId(oId);
		items.setPrice(book.getB_Price());
		items.setState(1);
		items.setTotal_Price(cart.getNum() * book.getB_Price());
		
		
		itemsDao.addItems(items);
		
	}

	@Override
	public List<OrdersAndStatus> findItem(String userName) {
		// TODO Auto-generated method stub
		List<OrdersAndStatus> list = null;
		try {
			list = itemsDao.findOrderByTiJian(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrdersAndStatus> searchOrder(String userName, String bookName) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("userName", userName);
		bookName = "%" + bookName + "%";
		map.put("bookName", bookName);
		List<OrdersAndStatus> list = null;
		try {
			list = itemsDao.searchOrder(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteBybId(String userName,Integer bId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("userName", userName);
		map.put("bId", bId);
		try {
			orderDao.deleteBybId(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	

}

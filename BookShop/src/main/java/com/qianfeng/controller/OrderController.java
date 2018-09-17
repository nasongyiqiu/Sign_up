package com.qianfeng.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.service.IOrdersService;
import com.qianfeng.util.JsonUtil;
import com.qianfeng.vo.JsonBean;
import com.qianfeng.vo.OrdersAndStatus;

@Controller
public class OrderController {
	@Autowired
	private IOrdersService ordersService;
	
	@RequestMapping("/buyShop")
	@ResponseBody
	public JsonBean addOrders(String info,HttpServletRequest request) {
		String[] bIdstr = info.split(",");
		ArrayList<Integer> list = new ArrayList<>();
		for (String string : bIdstr) {
			int bId = Integer.parseInt(string);
			list.add(bId);
		}
		String userName = (String) request.getSession().getAttribute("username");
//		遍历要添加的订单
		for (Integer bId : list) {
			ordersService.addItems(userName,bId);
			ordersService.deleteBybId(userName, bId);
		}
		return JsonUtil.getJsonBean(1, null);
	}
	
	
	@RequestMapping("/findItems")
	@ResponseBody
	public JsonBean findItems(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("username");
		List<OrdersAndStatus> list = null;
		try {
			list = ordersService.findItem(userName);
			return JsonUtil.getJsonBean(1, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtil.getJsonBean(0, e.getMessage());
		}
	}
	
	@RequestMapping("/searchOrder")
	@ResponseBody
	public JsonBean searchOrder(HttpServletRequest request,String bookName) {
		String userName = (String) request.getSession().getAttribute("username");
		List<OrdersAndStatus> list = null;
		try {
			list = ordersService.searchOrder(userName, bookName);
			return JsonUtil.getJsonBean(1, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtil.getJsonBean(0, e.getMessage());
		}
		
	} 

}

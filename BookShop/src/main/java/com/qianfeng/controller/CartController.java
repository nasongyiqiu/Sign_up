package com.qianfeng.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.Cart;
import com.qianfeng.service.ICartService;
import com.qianfeng.util.JsonUtil;
import com.qianfeng.vo.CartAndBooks;
import com.qianfeng.vo.JsonBean;

@Controller
public class CartController {
	@Autowired
	private ICartService cartService;
	
	@RequestMapping("/addCart")
	@ResponseBody
	public JsonBean addCart(String info,HttpServletRequest request) {
		String[] bIdstr = info.split(",");
		ArrayList<Integer> list = new ArrayList<>();
		for (String string : bIdstr) {
			int bId = Integer.parseInt(string);
			list.add(bId);
		}
		
		String userName = (String) request.getSession().getAttribute("username");
		for (Integer bid : list) {
			Cart cartc = new Cart();
			cartc.setbId(bid);
			cartc.setUserName(userName);
			cartc.setNum(1);
			
			Cart cart = cartService.findBybId(cartc);
			if (cart == null) {
				cartService.addBybId(cartc);
			}else {
				cartService.updataCartNum(cartc);
			}
		}
		return JsonUtil.getJsonBean(1, null);
		
	}
	
	
	@RequestMapping("/findAllCart")
	@ResponseBody
	public JsonBean findAllCart(HttpServletRequest request) {
		List<CartAndBooks> list = null;
		String userName = (String) request.getSession().getAttribute("username");
		try {
			list = cartService.findAllCart(userName);
			return JsonUtil.getJsonBean(1, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtil.getJsonBean(0, null);
		}
	}
	
	@RequestMapping("/searchCart")
	@ResponseBody
	public JsonBean searchCart(String keywords,HttpServletRequest request) {
		List<CartAndBooks> list = null;
		String username = (String) request.getSession().getAttribute("username");
		try {
			list = cartService.searchCart(username,keywords);
			return JsonUtil.getJsonBean(1, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtil.getJsonBean(0, e.getMessage());
		}
	}
	

}

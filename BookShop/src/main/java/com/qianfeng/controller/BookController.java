package com.qianfeng.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.Book;
import com.qianfeng.service.IBookService;
import com.qianfeng.util.JsonUtil;
import com.qianfeng.vo.JsonBean;
import com.qianfeng.vo.PageBean;

@Controller
public class BookController {
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public JsonBean findAllBook(int page) {
		JsonBean bean = new JsonBean(); 
		try {
			PageBean<Book> bookPage = bookService.findBookByPage(page);
			bean.setCode(1);
			bean.setMsg(bookPage);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public JsonBean findByName(String keywords) {
		
		List<Book> list = null;
		try {
			list = bookService.findByName(keywords);
			return JsonUtil.getJsonBean(1, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtil.getJsonBean(0, e.getMessage());
		}
	}
	
	

}

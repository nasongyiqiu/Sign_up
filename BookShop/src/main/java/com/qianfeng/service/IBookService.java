package com.qianfeng.service;

import java.util.List;

import com.qianfeng.entity.Book;
import com.qianfeng.vo.PageBean;

public interface IBookService {
	public List<Book> findAllBook();
	
	public PageBean<Book> findBookByPage(int page);

	public List<Book> findByName(String bookName);
}

package com.qianfeng.dao;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.Book;

public interface IBookDao {
	public List<Book> findAllBook();
	
	public int count();
	
	public List<Book> findByIndexAndSize(Map<String, Object> map);
	
	public List<Book> findByName(String bookName);
	
	public Book findBybId(int bId);

}

package com.qianfeng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.IBookDao;
import com.qianfeng.entity.Book;
import com.qianfeng.service.IBookService;
import com.qianfeng.vo.PageBean;
@Service
public class BookService implements IBookService{
	
	@Autowired
	private IBookDao bookDao;

	@Override
	public List<Book> findAllBook() {
		// TODO Auto-generated method stub
		List<Book> list = null;
		try {
			list = bookDao.findAllBook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public PageBean<Book> findBookByPage(int page) {
		// TODO Auto-generated method stub
		PageBean<Book> pageInfo = new PageBean<>();
		
		pageInfo.setCurrentPage(page);
		
		// 获取表中的记录总数
		int count = bookDao.count();
		// 计算总页数
		if(count % pageInfo.getPageSize() == 0){
			pageInfo.setTotalPage(count / pageInfo.getPageSize());
		}else{
			pageInfo.setTotalPage(count / pageInfo.getPageSize()+ 1);
		}
		// 根据页码计算分页查询时的开始索引
		int index = (page - 1) * pageInfo.getPageSize();
		Map<String, Object> map = new HashMap<>();
		map.put("index", index);
		map.put("size", pageInfo.getPageSize());
		
		List<Book> list = bookDao.findByIndexAndSize(map);
		pageInfo.setPageInfos(list);
		
		return pageInfo;
	}

	@Override
	public List<Book> findByName(String bookName) {
		// TODO Auto-generated method stub
		List<Book> list = null;
		try {
			bookName = "%" + bookName + "%";
			list = bookDao.findByName(bookName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

}

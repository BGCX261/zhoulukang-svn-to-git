package com.zlk.dao;

import java.util.List;

import com.zlk.pojo.News;
import com.zlk.pojo.Users;

public interface INewsDao {
	/**
	 * 添加新闻
	 */
	public boolean saveNews(News news);

	/**
	 * 根据id查找新闻
	 */
	public News getNewsByID(String id);

	/**
	 * 根据作者查找新闻
	 */
	public List getNewsByUser(Users user);

	/**
	 * 查找所有新闻
	 */
	public List getAllNews(int offset,int pagesize);
	public int getTotalCount();
}

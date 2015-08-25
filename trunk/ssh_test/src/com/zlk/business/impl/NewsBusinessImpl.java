package com.zlk.business.impl;

import java.util.Date;
import java.util.List;

import com.zlk.business.INewsBusiness;
import com.zlk.dao.INewsDao;
import com.zlk.pojo.News;
import com.zlk.pojo.Users;
import com.zlk.struts.form.NewsForm;
import com.zlk.util.ZlkUtil;

public class NewsBusinessImpl implements INewsBusiness{
private INewsDao newsDao;
private ZlkUtil zlkUtil;
public void setNewsDao(INewsDao newsDao) {
	this.newsDao = newsDao;
}
public void setZlkUtil(ZlkUtil zlkUtil) {
	this.zlkUtil = zlkUtil;
}

public boolean addNews(NewsForm newsForm) {
	// TODO Auto-generated method stub
	boolean flag = false;
	String title = newsForm.getTitle();
	String news = newsForm.getNews();
	Users author = newsForm.getAuthor();
	if(title == null || title.equals("")){
		return false;
	}
	if(news == null || news.equals("")){
		return false;
	}
	if(author == null){
		return false;
	}
	News n = new News();
	n.setId(zlkUtil.getUniqueString());
	n.setTitle(title);
	n.setNews(news);
	n.setAuthor(author);                                                 
	n.setDatetime(zlkUtil.String2Date("yyyy-dd-MM hh:mm:ss", new Date().toLocaleString()));
	flag = this.newsDao.saveNews(n);
	return flag;
}
public List getAllNews(int offset,int pagesize) {
	// TODO Auto-generated method stub
	return this.newsDao.getAllNews(offset,pagesize);
}
public News getNewsByID(String id) {
	// TODO Auto-generated method stub
	if(id!=null && !id.equals("")){
		return this.newsDao.getNewsByID(id);
	}
	return null;
}
public List getNewsByUser(Users user) {
	// TODO Auto-generated method stub
	return null;
}
public int getTotalCount() {
	// TODO Auto-generated method stub
	return this.newsDao.getTotalCount();
}


}

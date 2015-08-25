package com.zlk.business;

import java.util.List;

import com.zlk.pojo.News;
import com.zlk.pojo.Users;
import com.zlk.struts.form.NewsForm;

public interface INewsBusiness {
public boolean addNews(NewsForm newsForm);
public News getNewsByID(String id);
public List getNewsByUser(Users user);
public List getAllNews(int offset,int pagesize);
public int getTotalCount();
}

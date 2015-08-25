package com.zlk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zlk.dao.INewsDao;
import com.zlk.pojo.News;
import com.zlk.pojo.Users;

public class NewsDaoImpl extends HibernateDaoSupport implements INewsDao {

	public List getAllNews(final int offset, final int pagesize) {
		// TODO Auto-generated method stub
		List list = null;
		try {
			list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					// TODO Auto-generated method stub
					Query query = session.createQuery("from News");
					query.setFirstResult(offset);
					query.setMaxResults(pagesize);
					return query.list();
				}
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public News getNewsByID(String id) {
		// TODO Auto-generated method stub
		News news = null;
		List list = this.getHibernateTemplate().find("from News as news where news.id = ?",id);
		if(list!=null && list.size()>0){
			news = (News)list.get(0);
		}
		return news;
	}

	public List getNewsByUser(Users user) {
		// TODO Auto-generated method stub
		List list = null;
		try {
			list = this.getHibernateTemplate().find("from News as news where news.author = ?",user);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean saveNews(News news) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			this.getHibernateTemplate().save(news);
			flag = true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public int getTotalCount() {
		// TODO Auto-generated method stub
		int totalCount = ((Long)this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("select count(*) from News");
				return query.uniqueResult();
			}
		})).intValue();
		return totalCount;
	}

}

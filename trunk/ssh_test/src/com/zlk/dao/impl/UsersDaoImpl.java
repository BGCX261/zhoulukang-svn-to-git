package com.zlk.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zlk.dao.IUsersDao;
import com.zlk.pojo.Users;

public class UsersDaoImpl extends HibernateDaoSupport implements IUsersDao {

	public Users getUserByName(String username) {
		// TODO Auto-generated method stub
		Users users = null;
		try {
			String hql = "from Users as u where u.username = ?";
			List list = this.getHibernateTemplate().find(hql,username);
			if(list!=null && list.size()>0){
				users = (Users)list.get(0);
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public Users getUser(String username, String password) {
		// TODO Auto-generated method stub
		Users users = null;
		try {
			String hql = "from Users as u where u.username = ? and u.password = ?";
			List list = this.getHibernateTemplate().find(hql,new Object[]{username,password});
			if(list!=null && list.size()>0){
				users = (Users)list.get(0);
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public boolean saveUser(Users users) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			this.getHibernateTemplate().save(users);
			flag = true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}

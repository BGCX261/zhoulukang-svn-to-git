package com.zlk.business.impl;

import com.zlk.business.IUsersBusiness;
import com.zlk.dao.IUsersDao;
import com.zlk.pojo.Users;
import com.zlk.struts.form.LoginForm;
import com.zlk.util.ZlkUtil;

public class UsersBusinessImpl implements IUsersBusiness {
	private IUsersDao usersDao;
	private ZlkUtil zlkUtil;

	public void setUsersDao(IUsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void setZlkUtil(ZlkUtil zlkUtil) {
		this.zlkUtil = zlkUtil;
	}

	public boolean addUser(LoginForm loginForm) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		if(username!=null && !username.equals("") && password!=null && !password.equals("")){
			Users users = new Users();
			users.setId(zlkUtil.getUniqueString());
			users.setUsername(username);
			users.setPassword(password);
			flag = usersDao.saveUser(users);	
		}
		return flag;
	}

	public Users getUser(LoginForm loginForm) {
		// TODO Auto-generated method stub
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		if(username!=null && !username.equals("") && password!=null && !password.equals("")){
			return usersDao.getUser(username, password);
		}
		return null;
	}

	public boolean isExitUserName(LoginForm loginForm) {
		// TODO Auto-generated method stub
		String username = loginForm.getUsername();
		if(username!=null && !username.equals("")){
			Users users = usersDao.getUserByName(username);
			if(users != null){
				return true;
			}
		}
		return false;
	}

}

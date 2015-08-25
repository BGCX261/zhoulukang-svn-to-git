package com.zlk.dao;

import com.zlk.pojo.Users;

public interface IUsersDao {
	/**
	 * 检测用户名是否存在
	 */
	public Users getUserByName(String username);
	
	/**
	 * 判断用户名和密码是否存在
	 */
	public Users getUser(String username,String password);

	/**
	 * 添加用户
	 */
	public boolean saveUser(Users users);
}

package com.zlk.business;

import com.zlk.pojo.Users;
import com.zlk.struts.form.LoginForm;

public interface IUsersBusiness {
	/**
	 * 判断用户名是否存在
	 */
	public boolean isExitUserName(LoginForm loginForm);

	/**
	 * 用户登陆
	 */
	public Users getUser(LoginForm loginForm);

	/**
	 * 注册用户
	 */
	public boolean addUser(LoginForm loginForm);
}


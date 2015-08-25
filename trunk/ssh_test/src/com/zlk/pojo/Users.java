package com.zlk.pojo;

import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable,HttpSessionBindingListener {

	// Fields

	private String id;
	private String username;
	private String password;
	
	private Set news;
	
	public int count=0;

	// Constructors

	public Set getNews() {
		return news;
	}

	public void setNews(Set news) {
		this.news = news;
	}

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String id) {
		this.id = id;
	}

	/** full constructor */
	public Users(String id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		count++;
		System.out.println("当前在线人数:"+count);
		
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("用户 "+getUsername()+" 连接超时，强制退出");
		
	}

}
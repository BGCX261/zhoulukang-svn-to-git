package com.zlk.pojo;

import java.util.Date;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private String id;
	private String title;
	private String news;
	private Users author;
	private Date datetime;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String id) {
		this.id = id;
	}

	/** full constructor */
	public News(String id, String title, String news, Users author,
			Date datetime) {
		this.id = id;
		this.title = title;
		this.news = news;
		this.author = author;
		this.datetime = datetime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNews() {
		return this.news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public Users getAuthor() {
		return this.author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
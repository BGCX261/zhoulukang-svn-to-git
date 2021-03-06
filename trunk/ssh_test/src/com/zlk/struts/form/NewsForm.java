/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.zlk.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.zlk.pojo.Users;

/** 
 * MyEclipse Struts
 * Creation date: 04-19-2010
 * 
 * XDoclet definition:
 * @struts.form name="newsForm"
 */
public class NewsForm extends ValidatorForm {
	/*
	 * Generated fields
	 */

	/** id property */
	private String id;

	/** title property */
	private String title;

	/** news property */
	private String news;

	/** datetime property */
	private String datetime;
	
	private Users author;

	/*
	 * Generated Methods
	 */

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the id.
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/** 
	 * Set the id.
	 * @param id The id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** 
	 * Returns the title.
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/** 
	 * Set the title.
	 * @param title The title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** 
	 * Returns the news.
	 * @return String
	 */
	public String getNews() {
		return news;
	}

	/** 
	 * Set the news.
	 * @param news The news to set
	 */
	public void setNews(String news) {
		this.news = news;
	}

	/** 
	 * Returns the datetime.
	 * @return String
	 */
	public String getDatetime() {
		return datetime;
	}

	/** 
	 * Set the datetime.
	 * @param datetime The datetime to set
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
}